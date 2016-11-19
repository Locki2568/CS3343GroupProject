package exception;

public class InputMismatchException extends Exception {
	
	public InputMismatchException(){
		super("Invalid input detected! Exit Program Executed!");
	}
	
	public InputMismatchException(String message){
		super(message);
	}
	
}
