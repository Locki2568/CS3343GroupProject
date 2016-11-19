package exception;

public class InputMismatchException extends Exception {
	
	public InputMismatchException(){
		super("Invalid input detected! Exception is throwned!");
	}
	
	public InputMismatchException(String message){
		super(message);
	}
	
}
