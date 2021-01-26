package br.com.catrix.controllers.exception;

import java.io.Serializable;

public class PadraoError implements Serializable {

	private static final long serialVersionUID = 6275923839634868239L;

	private Integer status;
	private String mensagem;
	private Long timeStamp;

	public PadraoError(Integer status, String mensagem, Long timeStamp) {
		this.status = status;
		this.mensagem = mensagem;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
