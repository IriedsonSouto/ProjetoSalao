package Programa;

public class EmailInvalidoException extends Exception {

	private String message;
	
	public String getMessage(){
		return message;
	}
	public EmailInvalidoException(String message){
		this.message = message;
	}
}
