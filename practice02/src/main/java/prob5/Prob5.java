package prob5;

import java.util.Random;
import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */
			int input=0;
			int count=1;
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			System.out.println("수를결정하였습니다. 맞추어보세요");
			System.out.println("1-100");
			
			while(true) {
				
				/* 게임 작성 */
				
				System.out.print(count + ">>");
				
				input=scanner.nextInt();
				
				if (correctNumber == input) {
					System.out.println("맞았습니다.");
					count=0;	
					break;
				}else if(input>correctNumber) {
					System.out.println("더 낮게");
				}else {
					System.out.println("더 높게");
				}
				
				count++;
				
			}
			
			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();					
			if (answer.equals("n")) {
				break;
			}
					
		}
		
		scanner.close();
	}

}
