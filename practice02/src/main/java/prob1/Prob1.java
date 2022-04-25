package prob1;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * // //키보드에서 정수로 된 돈의 액수를 입력 받아 오만 원권, 만원 권, 오천 원권, 천원 권, // 500원 동전, 100원 동전,
		 * 50원 동전, 10원 동전, 1원 동전 각 몇 개로 변환 되는지 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in); 
		System.out.print("금액 : ");
		int count =scanner.nextInt();
		System.out.println();
		
		int won50000=0,won10000=0, won5000=0, won1000=0 ;
		int won500=0,won100=0,won50=0,won10=0,won1=0;
		
		int[] typeOfWon = {50000,10000,5000,1000,500,100,50,10,5,1};
		int[] wonCount = new int[10];
		
		
		for(int i=0; i<typeOfWon.length;i++) {
			if(count>=typeOfWon[i]) {
				wonCount[i]=count/typeOfWon[i];
				count = count % typeOfWon[i];
			}
		}
		
		
		for(int i=0; i<typeOfWon.length;i++) {
			System.out.println(typeOfWon[i] + "원 : " + wonCount[i] + "개");
		}
		
		
		
	}

}
