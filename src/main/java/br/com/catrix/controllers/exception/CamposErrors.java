package br.com.catrix.controllers.exception;

import java.io.Serializable;

public class CamposErrors implements Serializable {

	private static final long serialVersionUID = 7911918145467867228L;

	private String nomeDoCampo;
	private String mensagem;

	public CamposErrors() {
	}

	public CamposErrors(String nomeDoCampo, String mensagem) {
		this.nomeDoCampo = nomeDoCampo;
		this.mensagem = mensagem;
	}

	public String getNomeDoCampo() {
		return nomeDoCampo;
	}

	public void setNomeDoCampo(String nomeDoCampo) {
		this.nomeDoCampo = nomeDoCampo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
