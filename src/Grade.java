public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line

	//works out correct class from number of points
	public Classification classify() {
		if (points < 5) {
			return Classification.First;
		}
		else if (points < 9) {
			return Classification.UpperSecond;
		}
		else if (points < 13) {
			return Classification.LowerSecond;
		}
		else if (points < 17) {
			return Classification.Third;
		}
		return Classification.Fail;
	}
	
	//works out correct class from the percentage
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		if (g<=100 && g>78) {
			return new Grade(1);
		}
		else if (g<=78 && g>75) {
			return new Grade(2);
		}
		else if (g<=75 && g>72) {
			return new Grade(3);
		}
		else if (g<=72 && g>69) {
			return new Grade(4);
		}
		else if (g<=69 && g>66) {
			return new Grade(5);
		}
		else if (g<=66 && g>64) {
			return new Grade(6);
		}
		else if (g<=64 && g>61) {
			return new Grade(7);
		}
		else if (g<=61 && g>59) {
			return new Grade(8);
		}
		else if (g<=59 && g>56) {
			return new Grade(9);
		}
		else if (g<=56 && g>54) {
			return new Grade(10);
		}
		else if (g<=54 && g>51) {
			return new Grade(11);
		}
		else if (g<=51 && g>49) {
			return new Grade(12);
		}
		else if (g<=49 && g>46) {
			return new Grade(13);
		}
		else if (g<=46 && g>44) {
			return new Grade(14);
		}
		else if (g<=44 && g>41) {
			return new Grade(15);
		}
		else if (g<=41 && g>39) {
			return new Grade(16);
		}
		else if (g<=39 && g>34) {
			return new Grade(17);
		}
		else if (g<=34 && g>29) {
			return new Grade(18);
		}
		else if (g<=29 && g>=0) {
			return new Grade(19);
		}
		else if (g == -1){
			return new Grade(20);
		}
		throw new IllegalArgumentException();
	
	}

}
