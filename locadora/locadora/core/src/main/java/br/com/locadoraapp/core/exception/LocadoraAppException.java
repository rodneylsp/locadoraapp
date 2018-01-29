package br.com.locadoraapp.core.exception;

public class LocadoraAppException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LocadoraAppException() {
		super();
	}
	
	public LocadoraAppException(String mensagem) {
		super(mensagem);
	}

}
