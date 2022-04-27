package prob3;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		// 한국 원화를 달러로 변환
		double wonToDoller=won/rate;
		
		return wonToDoller;
	}

	public static double toKRW(double dollar) {
		// 달러를 한국 원화로 변환
		
		double dollarToWon=dollar*rate;
		
		return dollarToWon;
	}

	public static void setRate(double rate) {
		
		// 환율 설정(KRW/$1)
		CurrencyConverter.rate=rate;
		
	}
}
