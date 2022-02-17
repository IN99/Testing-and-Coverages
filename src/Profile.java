import java.awt.SecondaryLoop;
import java.util.List;

public class Profile {
	// Your additions/changes below this line
	List<Grade> grades;
	
	//frequency counter for each class
	int firstClassFreq = 0;
	int upperSecondClassFreq = 0;
	int lowerSecondClassFreq = 0;
	int thirdClassFreq = 0;

	public Profile(List<Grade> g) {
		this.grades = g;
		
		//check if list is null/empty
		if(g == null || g.isEmpty()) {
			throw new IllegalArgumentException();
		}
		//or contains fail
		else if(containsOneFail()){
			throw new IllegalArgumentException();
		}
		else {
			classFrequency();
		}
	}
		
	//method to check for fail grades
	private boolean containsOneFail() {
		boolean containsFail = false;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i).classify().equals(Classification.Fail)) {
				containsFail = true;
			}
		}
		
		return containsFail;
	}
	
	//method to add to the frequency counter based on the return value of classify method
	//in grade class
	private void classFrequency() {
		for(int i=0; i<grades.size(); i++) {
			Grade grade = grades.get(i); 
			if (grade.classify() == Classification.First) {
				firstClassFreq +=1;
			}
			else if (grade.classify() == Classification.UpperSecond) {
				upperSecondClassFreq +=1;
			}
			else if (grade.classify() == Classification.LowerSecond) {
				lowerSecondClassFreq +=1;
			}
			else {
				thirdClassFreq+=1;
			}
		}

	}

	//method to classify the profile based on the most occurring grade i.e over 50% 
	public Classification classify() {
		if ((double) firstClassFreq / grades.size() >= 0.5) {
			return Classification.First;
		} 
		else if ((double)upperSecondClassFreq / grades.size() >= 0.5){
			return Classification.UpperSecond;
		} 
		else if ((double)lowerSecondClassFreq / grades.size() >= 0.5 ){
			return Classification.LowerSecond;
		} 
		else {
			return Classification.Third;
		}
		
	}


	//checks if a profile is clear based on the number of third class grades over 25%
	public boolean isClear() {
		boolean clear = true;
		if ((this.classify().equals(Classification.First)) || (this.classify().equals(Classification.UpperSecond))) {
			if ((double) thirdClassFreq > grades.size() / 1/4) {
				clear= false;
			} 
		} 
		
		return clear;
	}

}
