import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfileTestCoverage {
	

	private static Stream<Arguments> testClearArgs(){
		return Stream.of(
				Arguments.of(1,8,7,7,true),
				Arguments.of(15,15,16,9,true));
	}
	
	//method to test the profile constructor using arguments above
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
