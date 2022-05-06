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
			
			
			//3. accept  이부분 무한루프로 돌려야함 올라갈 수 있게 ㅇㅇ 아니면 한번만 통신 가능한거 ㅇㅇ 
			// 클라이언트로 부터 요청을 기다린다.   
			Socket socket = serverSocket.accept(); // blocking 
			
			
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); // 리모트 상대편꺼 ㅇㅇ , 소켓보고 상대편꺼 달라고 요청
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
					//읽은 카운트수를 알아야 인코딩할 수 있음 대부분 256이 꽉차있지는 않음 어디까지 읽었는지를 알아야 데이터를 그 부분만 빼서 쓸 수 있으니까 ㅇㅇ 
					
					//클라이언트가 닫은걸 감지할 수 있어야함 파일이랑 같음, 파일끝부분 eof, 소켓에서는 반대편이 닫았다는 의미 
					if(readByteCount == -1) {
						//클라이언트가 정상적으로 종료 tcp 4웨이 핸드쉐이크 방식으로 ㅇㅇ 
						//클라이언트가 명시적으로 종료를 호출해서 정상적으로 종료되었다는거 -> close()를 호출해서 종료했다는 의미 
						//정상적으로 종료가 안되면 예외가 발해서 catch로 감. 소켓이셉션 발생 이걸로 제대로 종료했는지 아닌지를 알 수 있음 
						//확인을 하고 닫아야한다 
						System.out.println("[server] close by client"); // 정상종료 close() 써가지고 ㅇㅇ
						break; 
					}

					String data =new String(buffer,0,readByteCount,"UTF-8"); //디코딩작업, 바이트데이터를 스트링으로 컨버터 ㅇㅇ 
					System.out.println("[server] received : " + data );
					
					
					//6. 데이터 쓰기 
					os.write(data.getBytes("utf-8")); // 스트링을  바이트 utf로 인코딩 보낼때는 바이트로 보내야한다! 바이트로 통신 
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
