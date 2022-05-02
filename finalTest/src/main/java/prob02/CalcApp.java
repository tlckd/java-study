package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
			
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			//int result = arithmetic.calculate(lValue, rValue);
			//System.out.println( ">> " + result );
			
			switch(tokens[2]) {
				case "+":
					arithmetic = new Add();
					cal(arithmetic,lValue,rValue);
					break;
				case "-":
					arithmetic = new Sub();
					cal(arithmetic,lValue,rValue);
					break;
				case "*":
					arithmetic = new Mul();
					cal(arithmetic,lValue,rValue);
					break;
				case "/":
					arithmetic = new Div();
					cal(arithmetic,lValue,rValue);
					break;
			}
			
			
		}
		
		scanner.close();
	}
	
	static public void cal(Arithmetic ari , int lValue, int rValue ) {
		int result = ari.calculate(lValue, rValue);
		System.out.println( ">> " + result );
	}
	
}