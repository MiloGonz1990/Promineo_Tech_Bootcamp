
//Create a class named App that has a main method

//created two constructors to call and test both classes
public class App {

	public static void main(String[] args) {
		
		Logger logger = new AsteriskLogger();
		logger.log("Hello");
		System.out.println();
		logger.error("WARNING!!");
		
		Logger spacedLogger = new SpacedLogger();
		spacedLogger.log("Hello");
		System.out.println();
		spacedLogger.error("WARNING!!");
		System.out.println();
		
		

	}

}
