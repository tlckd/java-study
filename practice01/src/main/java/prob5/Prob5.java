package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=0; i<=99;i++) {
			
			
			if ((i / 10 == 3 || i / 10 == 6 || i / 10 == 9) && ((i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9)) {
				System.out.println(i + " 짝짝");
			} else if ((i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9) {
				System.out.println(i + " 짝");
			} else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				System.out.println(i + " 짝");
			}
		}
		
		
//		for(int i = 1; i <= 100; i++) {
//			String s = String.valueOf(i); 
//
//			int length = s.length();
//			int clap = 0;
//
//			for(int j = 0; j < length; j++) {
//				char c = s.charAt(j); -> chatAt으로 하나식 떄서 3,6,9 검사 
//				if(c == '3' || c == '6' || c == '9') {
//					clap++; charAt으로 떈거 3,6,9 있을때마다 1식 증가 
//				}
//			}
//
//			if(clap == 0) {
//				continue; -> 3,6,9 어디에도 해당하지 않으면 스킵 
//			}
//
//			System.out.print(s + " "); -> 해당 i번지의 값 출력후 증가된 clap값 만큼 짝 출력
//			for(int j = 0; j < clap; j++) {
//				System.out.print("짝"); 
//			}
//
//			System.out.print("\n");
//		}
			
		}
	}

