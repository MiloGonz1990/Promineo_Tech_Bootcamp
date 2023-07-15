import java.util.Random; 

public class TestDemo {
	
	//Create an instance method (not static) named addPositive
	//If both parameters are positive (greater than zero) return the sum of the parameters
	//If either parameter is zero or negative, throw an IllegalArgumentException with the message "Both parameters must be positive!"
	public int addPositive(int a, int b) {
	
		if(a > 0 && b > 0) {
		return (a+b);
	}
	else{
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}
	//add another method named randomNumberSquared. 
	//This method obtains a random int between 1 and 10 and then returns the square of the number.
 int randomNumberSquared(){
	 int randomint = getRandomInt();	
	 return randomint * randomint;  //returns the value obtained from getRandomInt * by itself
}
    //This method takes no parameters and must be package visibility so that the test can see it
 int getRandomInt() {
	 Random random = new Random();
	 return random.nextInt(10) + 1; 
 }

}
