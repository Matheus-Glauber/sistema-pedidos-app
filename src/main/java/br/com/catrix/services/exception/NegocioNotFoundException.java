package br.com.catrix.services.exception;

public class NegocioNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 4418559868620439028L;

	public NegocioNotFoundException(String name, Exception e) {
		super(name, e);
		// TODO Auto-generated constructor stub
	}
	
	public NegocioNotFoundException(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
