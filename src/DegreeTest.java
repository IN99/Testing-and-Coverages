import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DegreeTest {
	
	//testing year3 as a null list
	@Test
	public void testNull() {
		ArrayList<Grade> yr3Grades = null;
		ArrayList<Grade> yr2Grades = new ArrayList<>();
		yr2Grades.add(new Grade(10));
		
		Throwable ex = assertThrows(IllegalArgumentException.class, () ->	new Degree(yr2Grades, yr3Grades));

		Assertions.assertEquals(null, ex.getMessage());
	}
	
	//testing number of grades is not equal to 4 for year 3
	@Test
	public void testSize() {
    	List<Grade> yr3Grades = new ArrayList<>();
		List<Grade> yr2Grades = new ArrayList<>();
    	yr3Grades.add(new Grade(5));
    	
    	yr2Grades.add(new Grade(6));
    	yr2Grades.add(new Grade(7));
    	yr2Grades.add(new Grade(8));
    	yr2Grades.add(new Grade(9));
    	Throwable ex = assertThrows(IllegalArgumentException.class, () ->	new Degree(yr2Grades, yr3Grades));

		Assertions.assertEquals(null, ex.getMessage());
	}
	
	//Test if it contains fail in Degree constructor
	@Test
	public void testFailGrade() {
		List<Grade> yr3Grades = new ArrayList<>();
    	yr3Grades.add(new Grade(18));
    	yr3Grades.add(new Grade(4));
    	yr3Grades.add(new Grade(1));
    	yr3Grades.add(new Grade(1));
    	List<Grade> yr2Grades = new ArrayList<>();
    	yr2Grades.add(new Grade(11));
    	yr3Grades.add(new Grade(10));
    	yr3Grades.add(new Grade(10));
    	yr3Grades.add(new Grade(18));

    	Throwable ex = assertThrows(IllegalArgumentException.class, () ->	new Degree(yr2Grades, yr3Grades));

		Assertions.assertEquals(null, ex.getMessage());

	}
	
	//arguments for grades to be inputed into degree.
	private static Stream<Arguments> testClassArgs(){
		//2:1, 1st Test 
		List<Grade> yr2Grades = new ArrayList<>();
    	yr2Grades.add(new Grade(5));
    	yr2Grades.add(new Grade(5));
    	yr2Grades.add(new Grade(7));
    	yr2Grades.add(new Grade(7));
    	
    	List<Grade> yr3Grades = new ArrayList<>();
    	yr3Grades.add(new Grade(1));
    	yr3Grades.add(new Grade(2));
    	yr3Grades.add(new Grade(2));
    	yr3Grades.add(new Grade(5));
    	
		//2:1, 2:2 Test 
    	List<Grade> yr2Grades2 = new ArrayList<>();
    	yr2Grades2.add(new Grade(5));
    	yr2Grades2.add(new Grade(5));
    	yr2Grades2.add(new Grade(7));
    	yr2Grades2.add(new Grade(8));
    	
    
    	List<Grade> yr3Grades2 = new ArrayList<>();
    	yr3Grades2.add(new Grade(10));
    	yr3Grades2.add(new Grade(12));
    	yr3Grades2.add(new Grade(11));
    	yr3Grades2.add(new Grade(8));
    	
		//2:2, 3rd Test 
    	List<Grade> yr2Grades3 = new ArrayList<>();
    	yr2Grades3.add(new Grade(9));
    	yr2Grades3.add(new Grade(10));
    	yr2Grades3.add(new Grade(11));
    	yr2Grades3.add(new Grade(12));
    	
    	List<Grade> yr3Grades3 = new ArrayList<>();
    	yr3Grades3.add(new Grade(13));
    	yr3Grades3.add(new Grade(14));
    	yr3Grades3.add(new Grade(15));
    	yr3Grades3.add(new Grade(9));
    	
		//Equal profile 
    	List<Grade> yr2Grades4 = new ArrayList<>();
    	yr2Grades4.add(new Grade(4));
    	yr2Grades4.add(new Grade(4));
    	yr2Grades4.add(new Grade(4));
    	yr2Grades4.add(new Grade(4));
    	
    	List<Grade> yr3Grades4 = new ArrayList<>();
    	yr3Grades4.add(new Grade(1));
    	yr3Grades4.add(new Grade(2));
    	yr3Grades4.add(new Grade(2));
    	yr3Grades4.add(new Grade(3));
    	
    	//Check discretion
    	List<Grade> yr2GradesBorderline = new ArrayList<>();
    	yr2GradesBorderline.add(new Grade(6));
    	yr2GradesBorderline.add(new Grade(7));
    	yr2GradesBorderline.add(new Grade(8));
    	yr2GradesBorderline.add(new Grade(8));
    	
    	List<Grade> yr3GradesBorderline = new ArrayList<>();
    	yr3GradesBorderline.add(new Grade(3));
    	yr3GradesBorderline.add(new Grade(3));
    	yr3GradesBorderline.add(new Grade(15));
    	yr3GradesBorderline.add(new Grade(16));
    	
    	
		return Stream.of(
				Arguments.of(yr2Grades,yr3Grades,Classification.First),
				Arguments.of(yr2Grades2,yr3Grades2,Classification.UpperSecond),
				Arguments.of(yr2Grades3,yr3Grades3,Classification.LowerSecond),
				Arguments.of(yr2Grades4,yr3Grades4,Classification.First),
				Arguments.of(yr2GradesBorderline,yr3GradesBorderline,Classification.Discretion));	
	}
	
	//method to test classify method in degree using arguements above
	@ParameterizedTest
	@MethodSource("testClassArgs")
	void test(List<Grade> secYrGrades, List<Grade>thirdYrGrades, Classification output) {
		
		Degree degree = new Degree(secYrGrades, thirdYrGrades);
		assertEquals(degree.classify(), output);
	}
	

	
}
