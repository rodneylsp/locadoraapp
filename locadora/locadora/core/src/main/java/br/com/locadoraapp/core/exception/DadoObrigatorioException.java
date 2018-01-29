package br.com.locadoraapp.core.exception;

public class DadoObrigatorioException extends LocadoraAppException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3861482797150190009L;
	
	public DadoObrigatorioException() {
		super();
	}
	
	public DadoObrigatorioException(String mensagem) {
		super(mensagem);
	}

}
