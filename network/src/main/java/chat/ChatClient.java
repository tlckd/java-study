package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class ChatClient {
	Scanner scanner = null;
	Socket socket = null;
	String SERVER_IP = null; 
	private static final int SERVER_PORT=7777;
	
	public static void main(String[] args) {
		new ChatClient().go();
	}
	
	public void go(){
		try {
			
		//1. 키보드 연결
		scanner = new Scanner(System.in);
		
		
		SERVER_IP = InetAddress.getLocalHost().getHostAddress();
		
		//2. 소켓 생성
		socket = new Socket();
		
		//3. 연결 
		socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
		
		
		//4. reader/writer 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		//5. join 프로토콜 
		System.out.print("닉네임>>" );
		String nickname = scanner.nextLine();
		printWriter.println("join:" + nickname);
		printWriter.flush();
		
		if("join:ok".equals(bufferedReader.readLine())) {
		System.out.println("즐거운 채팅하세요! " + nickname + " 님!");
		
		
		//6. 스레드 시작 
		new ChatClientThread(bufferedReader).start();
		
		//7. 키보드 입력 처리 
		while(true) {
			System.out.print(">>");
			String input = scanner.nextLine();
			
			if("quit".equals(input)==true) {
				//8.quit 프로토콜 처리 
				printWriter.println("quit:");
				break;
			}else {
				//9.메시지 처리 
				if(input.length()==0) {
					input=" ";
				}
				printWriter.println("message:" + input);
				
			}
		}
		
		}//if문 끝 
		
		}catch(IOException ex) {
			log("error:" + ex);
		}finally {
			
			if(scanner != null) {
				scanner.close();
			}
			if(socket !=null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void log(String log) {
		System.out.println("[ChatClient] " + log);
	}
	
	
}
