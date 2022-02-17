import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class DegreeTestCoverage {
	
	//testing year2 as a null list
	@Test
	public void testNull() {
		ArrayList<Grade> yr2Grades = null;
		ArrayList<Grade> yr3Grades = new ArrayList<>();
		yr3Grades.add(new Grade(10));
		Throwable ex = assertThrows(IllegalArgumentException.class, () ->	new Degree(yr2Grades, yr3Grades));

		Assertions.assertEquals(null, ex.getMessage());
	}
	
	//testing number of grades is not equal to 4 for year 2
	@Test
	public void testSize() {
    	List<Grade> yr2Grades = new ArrayList<>();
		List<Grade> yr3Grades = new ArrayList<>();
    	yr2Grades.add(new Grade(5));
    	
    	yr3Grades.add(new Grade(6));
    	yr3Grades.add(new Grade(7));
    	yr3Grades.add(new Grade(8));
    	yr3Grades.add(new Grade(9));
    	Throwable ex = assertThrows(IllegalArgumentException.class, () ->	new Degree(yr2Grades, yr3Grades));

		Assertions.assertEquals(null, ex.getMessage());
	}
}
