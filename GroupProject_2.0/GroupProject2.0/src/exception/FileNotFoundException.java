package exception;

public class FileNotFoundException extends Exception {
	
	public FileNotFoundException(){
		super("File is not found! Exiting program executed!");
	}
	
	public FileNotFoundException(String message){
		super(message);
	}
	
}
