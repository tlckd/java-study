package util;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NSLookup {
	
	
	
	public static void main(String[] args) {
		//과제 nslookup 구현해보기 서버프로그래밍 ppt 34장에 있는거
		String inputDomain=null;
		Scanner scan = new Scanner(System.in);
		try {
		while(!"quit".equals(inputDomain)) {
			
			System.out.print("도메인 입력 : ");
			inputDomain=scan.nextLine();
			System.out.println(">> " + InetAddress.getByName(inputDomain));
			
		}
		}catch(Exception e) {
			e.getMessage();
		}
		
	}

}
