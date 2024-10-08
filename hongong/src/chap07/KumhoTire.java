package chap07;

public class KumhoTire extends Tire {

	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		accRotation++;
		if (accRotation < maxRotation) {
			System.out.println(location + " KumhoTireTire 수명 : " + (maxRotation - accRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + " KumhoTireTire 펑크 ***");
			return false;
		}
	}

}
