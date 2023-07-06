//create interface named logger
// an Interface is an outline for a class


public interface Logger {
	//add two void methods to the logger interface, each should take a string as an argument (Log,Error)
	public void log(String log);
	public void error(String error);

	
	//Create two classes that implement the Logger interface (AsteriskLogger,SpacedLogger)
}
