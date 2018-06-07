package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	public boolean validar(Usuario usuario) {
		String sql = "SELECT nome, senha FROM usuario WHERE nome = ? and senha = ?";
		try{
			Connection conn = ConnectionFactory.obtemConexao();
			try(PreparedStatement ps = conn.prepareStatement(sql);){
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getSenha());
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}catch(SQLException e2) {
				System.out.print(e2.getStackTrace());
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
