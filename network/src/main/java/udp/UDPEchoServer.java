package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {

	public static final int PORT=9999;
	public static final int BUFFER_SIZE=1024;
	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		
		try {
			//1. 소켓 생성 
			socket =new DatagramSocket(PORT);
			
			while(true) {
				//2. 데이터 수신
				DatagramPacket rcvPacket =new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE ); // 버퍼(배열)만들고 사이즈 알려줌 
				socket.receive(rcvPacket); // 블락킹 데이터그램 패킷을 받을때까지 ㅇㅇ , 데이터그램 버퍼에 수신된 데이터로 채워짐 ( 보낸사람 ip 주소, 컴퓨터 포트 같은거 ) 

				byte[] rcvData =rcvPacket.getData();
				int length  = rcvPacket.getLength();
				String message = new String(rcvData,0,length, "UTF-8");
				System.out.println("[server] receive: " + message);
				
				//3. 데이터 송신
				// 새봉투 마련 .. 
				byte[] sndData =  message.getBytes("utf-8"); // 인코딩 해주기  
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length,rcvPacket.getAddress(),rcvPacket.getPort()); // 받는놈 ip주소 포트주소
				socket.send(sndPacket); // 보내기 
				
				
			}
		} catch (SocketException e) {
			System.out.println("Error:" + e);
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error:" + e);
			e.printStackTrace();
		} finally {
			if(socket !=null&& !socket.isClosed()) {
			socket.close();
			}
		}
		
	}

}
