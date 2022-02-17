import java.util.ArrayList;
import java.util.List;

public class Degree {
	// Your additions/changes below this line

	
	//declares each profile
	Profile profile5;
	Profile profile6;
	
	//take two list arguments and check for null etc and assign the profiles
	public Degree(List<Grade> yr2Grades, List<Grade> yr3Grades) {
		if(yr2Grades == null || yr3Grades == null || yr2Grades.size() !=4 || yr3Grades.size() !=4) {
			throw new IllegalArgumentException();
		} 
		else {
			profile5= new Profile(yr2Grades);
			profile6 = new Profile(yr3Grades);
			yr2Grades.addAll(yr3Grades); 
		}
	}
	
	//method that classifies the degree based on which profile weighs higher or if equal, else
	//applies dicretion
	public Classification classify() {
		
		if(profile5.classify().equals(profile6.classify())) {
			return profile5.classify();
		}		
		
		else if(profile6.classify().ordinal() > profile5.classify().ordinal() && !(profile6.classify().ordinal() - profile5.classify().ordinal() > 1) && profile6.isClear() ) {
			return profile6.classify();
		}
		else if(profile5.classify().ordinal() > profile6.classify().ordinal() && !(profile5.classify().ordinal() - profile6.classify().ordinal() > 1) && profile5.isClear() ) {
			return profile5.classify();
		}
		else {
			return Classification.Discretion;
		}
	}
	
}
