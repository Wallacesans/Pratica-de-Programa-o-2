package model;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversiouid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", senha=" + senha + "]";
	}
}