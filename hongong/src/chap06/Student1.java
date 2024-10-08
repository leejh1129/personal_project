package chap06;

public class Student1 {

	String name_id;
	String name;
	int korean;
	int math;
	int english;
	

	Student1(String name_id, String name, int korean, int math, int english){
		this.name_id =name_id;
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}



	int plus() {
		return  korean + math + english;
	}
	
	double avg() { 
		return plus() / 3;
	}

	String grade() {
		if(avg() >= 90) {
			return "A";
		}else if((avg()) >= 80){
			return "B";
		}else if((avg()) >= 70){
			return "C";
		}else if((avg()) >= 60){
			return "D";
		}else {
			return"F";
		}
	}
	

	void result() {
		System.out.printf("%s : %s : %d : %d : %d : %d : %f : %s \n", name_id, name, korean, math, english, plus(),avg(),grade());
	}



	
}
