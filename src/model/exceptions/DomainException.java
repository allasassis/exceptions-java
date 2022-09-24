package model.exceptions;

// RuntimeException � um tipo de extens�o que o compilador n�o obriga voc� a tratar, j� Exception voc� � obrigado a tratar
public class DomainException extends Exception{
	private static final long serialVersionUID = 1L; // assim que se declara a vers�o de serial de uma classe 
	
	public DomainException(String msg) {
		super(msg);
	}
	
	
}
