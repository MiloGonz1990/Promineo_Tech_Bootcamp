
public class SpacedLogger implements Logger {

	//The Log method should add spaces between each character of the String argument passed into its method
	//The error method should do the same, but with “ERROR:” 
	//used a method .replace that allows me to replace char values
	//.trim cuts off the leading spaces
	@Override
	public void log(String log) {
		
		System.out.println(log.replace("", " ").trim());
		
		
	}

	@Override
	public void error(String error) {
		System.out.println("ERROR: "+ error.replace("", " ").trim());
	}
	
}
