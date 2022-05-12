package chat.gui;

import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	Socket socket;
	ServerSocket serverSocket;
	private static final int PORT=7777;
	List<Writer> listWriters = new ArrayList<Writer>();
	
	
	public static void main(String[] args) {
		new ChatServer().go();
	}
	
	public void go() {
		try {
			serverSocket = new ServerSocket(); // 명시적으로 안하면 0.0.0.0 자동적으로 들어감, 밑에있는건 명시적으로 ip설정 하는거 ㅇㅇ  
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			log( "연결 기다림" + hostAddress +":"+ PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				
				//스레드 시작 
				new ChatServerThread(socket, listWriters).start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}
	
	
}
