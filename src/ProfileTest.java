import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfileTest {

	//test to check if returns error when given empty list
	@Test
	void testNotEmpty() {
		ArrayList<Grade> list = new ArrayList<>();
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Profile(list));

		Assertions.assertEquals(null, ex.getMessage());
	}
	
	//test to check null input for grade list returns error
	@Test
	void testNull() {
		ArrayList<Grade> list = null;
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Profile(list));

		Assertions.assertEquals(null, ex.getMessage());
	}
	
	//test to check if list contains at least one fail
	@Test
	 void testFail() {
		ArrayList<Grade> list = new ArrayList<>();
		list.add(new Grade(17)); 
		list.add(new Grade(17));
		list.add(new Grade(1));
		list.add(new Grade(9));
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Profile(list));

		Assertions.assertEquals(null, ex.getMessage());
	
	}
	
	//test list of grades returns correct class
	private static Stream<Arguments> testClassesArgs(){
		return Stream.of(
				Arguments.of(1,4,6,3,Classification.First),
				Arguments.of(1,6,6,9,Classification.UpperSecond),
				Arguments.of(4,10,12,9,Classification.LowerSecond),
				Arguments.of(13,16,1,5,Classification.Third));	
	}
	
	//test list of grades returns correct class
	@ParameterizedTest
	@MethodSource("testClassesArgs")
	void testClass(int g1, int g2,int g3,int g4,Classification cl) {
		ArrayList<Grade> list = new ArrayList<>();
		list.add(new Grade(g1));
		list.add(new Grade(g2));
		list.add(new Grade(g3));
		list.add(new Grade(g4));
		Profile profile = new Profile(list);
		assertEquals(profile.classify(),cl);
	}
	
	//test list of grades returns borderline or clear
	private static Stream<Arguments> testClearArgs(){
		return Stream.of(
				Arguments.of(1,3,16,15,false),
				Arguments.of(1,1,6,9,true));
	}
	
	//test list of grades returns borderline or clear
	@ParameterizedTest
	@MethodSource("testClearArgs")
	void testClear(int g1, int g2,int g3,int g4, boolean output) {
		ArrayList<Grade> list = new ArrayList<>();
		list.add(new Grade(g1));
		list.add(new Grade(g2));
		list.add(new Grade(g3));
		list.add(new Grade(g4));
		Profile profile = new Profile(list);
		assertEquals(profile.isClear(),output);
	}
	
	
}
