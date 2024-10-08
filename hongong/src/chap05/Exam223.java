package chap05;

public class Exam223 {

	public static void main(String[] args) {
		
		// 문제5번
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int cnt = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int idx : array[i]) {
				cnt++;
				sum += idx;
			}
		}
		avg = (double)sum / cnt;
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

	}

}
