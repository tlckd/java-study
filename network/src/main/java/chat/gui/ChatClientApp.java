package chat.gui;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;



public class ChatClientApp {
	
	String SERVER_IP = null; 
	private static final int SERVER_PORT=7777;
	Socket socket;
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);


		
		while(true) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한 글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		// 옆에 접속유저 띄울려면 프린트라이트로 가지고있는게 아니라 쳇유저로 가지고 있어야함 ㅇㅇ 

		new ChatClientApp().go(name);
		
	}
	
	public void go(String name) {
		try {
		SERVER_IP = InetAddress.getLocalHost().getHostAddress();
		//1. creat socket 
		socket = new Socket();
		
		//2. connect server 
		socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
		
		//3. get iostream(pipline established)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		//4. join protocol 처리 
		printWriter.println("join:" + name);
		
		if("join:ok".equals(bufferedReader.readLine())) {
			new ChatWindow(name, socket, bufferedReader, printWriter).show();
			System.out.println("연결됨");
		}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
