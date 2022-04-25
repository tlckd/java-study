package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i=0; i<=99;i++) {
			if((i%10)==3 || (i%10)==6 || (i%10)==9 ) {
				System.out.println( i+  " 짝");
				}else if(i/10==3 || i/10==6 ||i/10==9) {
					System.out.println( i+  " 짝");
				}
			}
			
		}
	}

