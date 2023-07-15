import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream; 
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();
	
	}

	@ParameterizedTest
	//add the annotation @MethodSource. Pass a single parameter to @MethodSource.
	//It must be the fully-qualified (includes package) class name of the test followed
	//by a # sign followed by the name of the method that supplies the parameters
	
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	//Add four parameters int a, int b, int expected, boolean
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, 
			int expected, boolean expectException) {
		
		//If it is false, assert that when TestDemo.addPositive is called 
		//with values a and b, that the result is the same as the parameter expected. 
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> 
				testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	//Create a static method named argumentsForAddPositive. 
	//It should not have any parameters and it should return a Stream of Arguments. 
	//Each parameter set should be wrapped in an arguments() method call. 
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(2, 3, 5, false),
				arguments(5, 0, 5, true),
				arguments(-2, -4, -6, true),
				arguments(4, 4, 8, false),
				arguments(2, 3, 5, false),
				arguments(-2, 0, -2, true),
				arguments(-2, -4, -6, true),
				arguments(0, 1, 1, true)
				);
	}
	@Test
    void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
	
		doReturn(5).when(mockDemo).getRandomInt();
	
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	
    }

}
