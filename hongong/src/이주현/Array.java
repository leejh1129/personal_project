package 이주현;

public class Array {

	public static void main(String[] args) {

		// 1.번
//		int[] nums = new int[10];
//		for(int i = 0; i < nums.length; i++) {
//			int ran = (int)(Math.random() * 100) + 1;
//			nums[i] = ran;
//		}
//
//		int sum = 0;
//		int max = 0;
//		int min = 100;
//		for(int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + " ");
//			sum += nums[i];
//			if(max < nums[i]) {
//				max = nums[i];
//			}
//			if(min > nums[i]) {
//				min = nums[i];
//			}
//		}
//		System.out.println();
//		System.out.println("배열의 합계 : " + sum);
//		System.out.println("배열의 최대값 : " + max);
//		System.out.println("배열의 최소값 : " + min);
//		// 2.번
//		int[][] su = {
//				{1, 2, 3},
//				{1, 2},
//				{1},
//				{1, 2, 3}
//		}; 
//		for(int i = 0; i < su.length; i++) {			
//			for(int idx : su[i]) {
//				System.out.print(idx + " ");
//			}
//			System.out.println();
//		}

		
//		// 3.번
//		int[][] seat = new int[3][10];
//		int cnt = 0;
//		for(int i = 0; i < seat.length; i++) {
//			for(int j = 0; j < seat[i].length; j++) {
//				int ran = (int)(Math.random() * 2);
//				seat[i][j] = ran;
//				System.out.print(seat[i][j] + " ");		
//				if(ran == 1) {
//					cnt++;
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("현재 관객 수 : " + cnt);

		
		// 4.번
//		int[][] susu = new int [3][5];
//		int[] avg = new int[3];
//		for(int i = 0; i < susu.length; i++) {
//			int sum1 = 0;
//			for(int j = 0; j < susu[i].length; j++) {
//				int ran = (int)(Math.random() * 51) + 50;
//				susu[i][j] = ran;
//				System.out.print(susu[i][j] + " ");
//				sum1 += susu[i][j];
//			}
//		    avg[i] = sum1 / 5;
//			System.out.println();
//		}
//		for(int i = 0; i < avg.length; i++) {
//			System.out.printf("%d 번 학생 평균 : %d \n", i+1 , avg[i]);
//		}

		
		// 5.번
		String[] cardStr = {"Clubs","Diamonds","Hearts","Spades"};
		String[] cardNum = {"2","3","4","5","6","7","8","9","Jack","Queen","King","Ace"};
		
		for(int i = 0; i < 5; i++) {
			int ranStr = (int)(Math.random() * 3);
			int ranNum = (int)(Math.random() * 11);
			System.out.printf("%s의 %s \n", cardStr[ranStr], cardNum[ranNum]);
		}

		
		// 6.번
//		int[][] nums = new int[3][5];
//		int cnt = 0;		
//		
//		while(cnt < 5) {
//			
//			int ran = (int)(Math.random() * 3);
//			int ran2 = (int)(Math.random() * 5);
//			
//			if(nums[ran][ran2] == 0) {
//				nums[ran][ran2] = 1;
//				cnt++;
//			}
//		}
//		
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = 0; j < nums[i].length; j++) {
//				System.out.print(nums[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

}
