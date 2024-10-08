package chap01;

public class Escape88 {

	public static void main(String[] args) {
		
		// static 객체없이 사용가능하게 만들어줌
		// void 리턴값 없음
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄\\여름\\가을\\겨울");
		
		// p91
		// 예제에 시작합니다 출력 되도록 변경
		boolean stop = true;
		boolean state = false;
		if(!stop/*state*/) {
			System.out.println("중지합니다");
		}else {
			System.out.println("시작합니다.");
		}
		
		// p103
		// 타입변환
		byte byteValue1 = 10;
		byte byteValue2 = 10;
		//byte byteValue3 = byteValue1 + byteValue2; 컴파일 에러
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		//char charValue3 = charValue1 + charValue2; 컴파일 에러
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		//int intValue6 = 10 / 4.0;
		double doubleValue = intValue5 / 5.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		
		// p106
		// 문자열 -> 숫자 , 숫자 -> 문자열 변환
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 : " + (value1 + 100));
		System.out.println("value2 : " + (value2 + 100));
		System.out.println("value3 : " + value3 + 100);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1 : " + str1 + 100);
		System.out.println("str2 : " + str2 + 100);
		System.out.println("str3 : " + str3 + 100);
		
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		
		System.out.println(c2);
		System.out.println((int)c2);
		
		int x1 = 5;
		int y1 = 2;
		int result1 = x1 / y1;
		System.out.println("result1 : " + result1);
		
		
		int x2 = 5;
		int y2 = 2;
		double result2 = (double)x2 / y2;
		System.out.println("result2 : " + result2);
		
		
		double var1 = 3.5;
		double var2 = 2.7;
		int result3 = (int)(var1 + var2);
		System.out.println("result3 : " + result3);

		
		
		long var3 = 2l;
		float var4 = 1.8f;
		double var5 = 2.5;
		String var6 = "3.9";
		int result4 = (int)(var3 + var4 + var5 + (int)Double.parseDouble(var6));
		System.out.println("result4 : " + result4);
		
		
		String str4 = 2 + 3 + "";
		String str5 = 2 + "" + 3;
		String str6 = "" + 2 + 3;
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		
		
		byte value = Byte.parseByte("10");
		int valueInt = Integer.parseInt("1000");
		float valueFloat = Float.parseFloat("20.5");
		double valueDouble = Double.parseDouble("3.14159");


	}

}
