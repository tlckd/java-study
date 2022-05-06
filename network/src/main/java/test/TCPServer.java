package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버소켓 생성 
			serverSocket = new ServerSocket();
			
			//2. 바인딩(binding) 
			// Socekt에 InetSocketAddress(IP Address + 포트 )를 바인딩한다.
			// IPAddress(0.0.0.0) : 특정 호스트 IP를 바인딩 하지 않는다.  
			// backlog : 요청 queue 
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5555),10);
			
			
			//3. accept  
			// 클라이언트로 부터 요청을 기다린다.   
			Socket socket = serverSocket.accept(); // blocking 
			
			
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); 
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			
		
			System.out.println("[server] connected by client[" + remoteHostAddress + "]" + " :  " + remoteHostPort);
			
			try {
				//4. IO Stream 받아오기 
				InputStream is = socket.getInputStream(); 
				OutputStream os = socket.getOutputStream();
				
				
				while(true) {
					//5. 데이터 읽기 
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking 쓰지않을때는 블락킹됨 
					
					
					if(readByteCount == -1) {

						System.out.println("[server] close by client"); 
						break; 
					}

					String data =new String(buffer,0,readByteCount,"UTF-8"); 
					System.out.println("[server] received : " + data );
					
					
					//6. 데이터 쓰기 
					os.write(data.getBytes("utf-8")); 
					// 클라이언트에게 전송 
					
					
				}
			}catch(SocketException ex) {
				System.out.println("[server] 갑자기 닫힘 :" + ex );
			}
			 catch(IOException ex) {
				System.out.println("[server] error:" + ex );
			} finally {
				try {
				if(socket != null && serverSocket.isClosed()==false)	{
				socket.close(); // 소켓만 닫으면 됨 
				}
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			
			
		} catch (IOException e) {
			System.out.println("[server] error : " + e);
		}finally {
			try {
			if(serverSocket != null && serverSocket.isClosed()==false) { 
				serverSocket.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
