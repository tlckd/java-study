package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 -a;
		
		System.out.println("some code .....1");

		
		try {
			System.out.println("some code .....2");
		int result = (1+2+3)/b; 
		System.out.println("some code .....3");
		}catch(ArithmeticException ex) {
			/* 예외 처리 */
			//1. 사과안내문 보내기 
			System.out.println("미안합니다.");
			//2.로깅, 파일같은 문서로 남기기 log4j 같은걸로 -> 유지보수에 필요 
			System.out.println("error: " + ex);
			//3. 정상 종료 
			return;
			
		}finally {
			System.out.println("자원 정리");
		}
		
	}

}
	