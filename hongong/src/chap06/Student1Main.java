package chap06;

public class Student1Main {

	public static void main(String[] args) {
		
		
		Student1 student1 = new Student1("240927","이주현",80, 90, 88);
		Student1 student2 = new Student1("240927","권순범",82, 50, 88);
		Student1 student3 = new Student1("240927","서승교",80, 60, 48);
		Student1 student4 = new Student1("240927","조창재",70, 90, 88);
		Student1 student5 = new Student1("240927","강현진",60, 50, 88);
		
		student1.result();
		student2.result();
		student3.result();
		student4.result();
		student5.result();
		
		Student1 st[] = {
				new Student1("240927","이주현",80, 90, 88),
				new Student1("240927","이주현",80, 90, 88),
				new Student1("240927","이주현",80, 90, 88),
				new Student1("240927","이주현",80, 90, 88),
				new Student1("240927","이주현",80, 90, 88),
		};
		
		for(Student1 student : st) {
			System.out.println();
		}
		
		
	}

}
