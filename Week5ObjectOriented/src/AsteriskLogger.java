
public class AsteriskLogger implements Logger {
	
	//log method should print out the String it receives between 3 asterisks 
	//error method should print the String it receives inside a box of asterisks , with the word “ERROR:”
	@Override
	public void log(String log) {
		
			System.out.println("***" + log + "***");
		
	}

	@Override
	public void error(String error) {
		System.out.println("**********************");
		System.out.println("***ERROR: " + error + "***");
		System.out.println("**********************\n");
		
	}
	
	

}
