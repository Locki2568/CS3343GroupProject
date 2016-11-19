package validate;

public class ValidateInput {
	
	public static boolean validBooleanInput(String in){
		boolean valid = false;
		
		if((in.equals("false")) || (in.equals("true")))
			valid = true;
		
		return valid;
	}
	
	public static boolean validNumericInput(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
}
