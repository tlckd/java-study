package prob1;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		/* 코드 작성 */
		
		System.out.print("금액 : ");
		int count =scanner.nextInt();
		System.out.println();
		
		int won50000=0,won10000=0, won5000=0, won1000=0 ;
		int won500=0,won100=0,won50=0,won10=0,won1=0;

		int[] wonCount = new int[10];
				
		for(int i=0; i<MONEYS.length;i++) {
			if(count>=MONEYS[i]) {
				wonCount[i]=count/MONEYS[i];
				count = count % MONEYS[i];
			}
		}
		
		
		for(int i=0; i<MONEYS.length;i++) {
			System.out.println(MONEYS[i] + "원 : " + wonCount[i] + "개");
		}
		
		scanner.close();
		
	}

}
