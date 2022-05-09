package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	
	private static final String SERVER_IP ="127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	private static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;
	//public static final int BUFFER_SIZE=1024;
	//public static final int PORT=9999;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null ;
		
		
		try {
			
		//1. Scanner 생성 
		scanner = new Scanner(System.in);
		
		//2. Socekt 생성 
		socket = new DatagramSocket();
			
		while(true) {
			System.out.print(">>");
			String line = scanner.nextLine();
			
			if("exit".equals(line)) {
				break;
			}
			
			
			//3. 보내기 
			byte[] sndData =  line.getBytes("utf-8"); // 인코딩 해주기  
			DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length,new InetSocketAddress("127.0.0.1",9999)); 
			socket.send(sndPacket); // 보내기 
			
			//4.받기 
			DatagramPacket rcvPacket =new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE ); // 버퍼(배열)만들고 사이즈 알려줌 
			socket.receive(rcvPacket); // 블락킹 데이터그램 패킷을 받을때까지 ㅇㅇ , 데이터그램 버퍼에 수신된 데이터로 채워짐 ( 보낸사람 ip 주소, 컴퓨터 포트 같은거 ) 

			byte[] rcvData =rcvPacket.getData();
			int length  = rcvPacket.getLength();
			String message = new String(rcvData,0,length, "UTF-8");
			System.out.println("<< " + message);
		}
		
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("Error " + e);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(scanner != null) {
				scanner.close();
				
			}
			if(socket !=null && !socket.isClosed()) {
				socket.close();
			}
		}

	}
}
