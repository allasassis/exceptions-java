package model.exceptions;

// RuntimeException é um tipo de extensão que o compilador não obriga você a tratar, já Exception você é obrigado a tratar
public class DomainException extends Exception{
	private static final long serialVersionUID = 1L; // assim que se declara a versão de serial de uma classe 
	
	public DomainException(String msg) {
		super(msg);
	}
	
	
}
