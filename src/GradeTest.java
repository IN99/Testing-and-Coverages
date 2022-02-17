import java.util.*;
import java.util.stream.Stream;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;


class GradeTest {

	//test to check under the boundary value
	@Test
	public void testOutOfRange1() {
	    Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Grade(-2));
		
		Assertions.assertEquals(null, ex.getMessage());
		
	}
	
	//test to check over the boundary value
	@Test
	public void testOutofRange2() {
	    Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Grade(23));
		
		Assertions.assertEquals(null, ex.getMessage());
		
	}
	
	//Test to check points return correct value
	@Test	
	public void getPoints() {
		Grade grade = new Grade(10);
		assertEquals(grade.getPoints(), 10);
	}
	
	//Test to check fail grade return a fail classification
	@Test
	public void testFail() {
		Grade grade = new Grade(18);
		assertEquals(grade.classify(), Classification.Fail);
	}
	
	//Test to check classify returns first
	@Test
	public void testFirstClass() {
		Grade grade = new Grade(2);
		assertEquals(grade.classify(), Classification.First);
	}	
	
	
	//Test to check classify returns 2:1
	@Test
	public void testUpperSecondClass() {
		Grade grade = new Grade(6);
		assertEquals(grade.classify(), Classification.UpperSecond);
	}
	
	//Test to check classify returns 2:2
	@Test
	public void testLowerSecondClass() {
		Grade grade = new Grade(11);
		assertEquals(grade.classify(), Classification.LowerSecond);
	}
	

	//Test to check classify returns third
	@Test
	public void testThirdClass() {
		Grade grade = new Grade(15);
		assertEquals(grade.classify(), Classification.Third);
	}
	
	
	//Test to check below valid range for fromPercentage
	@Test
	public void testForBelowPercentage() {
	    Throwable ex = assertThrows(IllegalArgumentException.class, () -> Grade.fromPercentage(-6));
	    assertEquals(null, ex.getMessage());
	}
	
	//Test to check above valid range for fromPercentage
	@Test
	public void testForAbovePercentage() {
	    Throwable ex = assertThrows(IllegalArgumentException.class, () -> Grade.fromPercentage(105));
	    assertEquals(null, ex.getMessage());
	}
	
	//setting the arguments for the test method
	private static Stream<Arguments> fromPercentageGen(){
		return Stream.of(
				Arguments.of(80,1),
				Arguments.of(77,2),
				Arguments.of(73,3),
				Arguments.of(71,4),
				Arguments.of(68,5),
				Arguments.of(65,6),
				Arguments.of(63,7),
				Arguments.of(60,8),
				Arguments.of(58,9),
				Arguments.of(55,10),
				Arguments.of(53,11),
				Arguments.of(50,12),
				Arguments.of(48,13),
				Arguments.of(45,14),
				Arguments.of(43,15),
				Arguments.of(40,16),
				Arguments.of(37,17),
				Arguments.of(32,18),
				Arguments.of(20,19),
				Arguments.of(-1,20));		
	}
	
	//method to test fromPercentage using arguments above
	@ParameterizedTest
	@MethodSource("fromPercentageGen")
	void testPercentage(int x, int y) {
		Grade grade = Grade.fromPercentage(x);
		assertEquals(grade.getPoints(), y);
	}
	
	
}
