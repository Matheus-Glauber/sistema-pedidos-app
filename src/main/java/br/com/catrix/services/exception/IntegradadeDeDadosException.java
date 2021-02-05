package br.com.catrix.services.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class IntegradadeDeDadosException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 1726551210866834720L;

	public IntegradadeDeDadosException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IntegradadeDeDadosException(String msg) {
		super(msg);
	}

}
