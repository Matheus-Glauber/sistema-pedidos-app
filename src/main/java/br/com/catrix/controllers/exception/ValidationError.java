package br.com.catrix.controllers.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends PadraoError {

	private static final long serialVersionUID = -7152214342785242323L;

	private List<CamposErrors> erros = new ArrayList<CamposErrors>();

	public ValidationError(Integer status, String mensagem, Long timeStamp) {
		super(status, mensagem, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<CamposErrors> getErros() {
		return erros;
	}

	public void addError(String nomeDoCampo, String mensagem) {
		this.erros.add(new CamposErrors(nomeDoCampo, mensagem));
	}

}
