package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

	private static final String IP="127,0.0.1";
	private static final int PORT = 6666;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버소켓 생성 
			serverSocket = new ServerSocket();		
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("stats...[port: " + PORT + "]");
			
			Socket socket = serverSocket.accept(); // blocking 
			
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); 
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			
			log("connected by client[" + remoteHostAddress + "]" + " :  " + remoteHostPort);
			
			try {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); //true로 자동 flush 설정, 버퍼에 차는즉시 씀 
				
					
				
				while(true) {
					
					String data = br.readLine(); // 개행을 만들어줘야 읽을 수 있음, 개행까지만 읽음 
					//인코딩 같은거 없이 읽을 수 있음 , 보조스트림이 알아서 처리해줌 
					
					if(data == null) {
						log("close by client"); 
						break; 
					}

					
					log("received : " + data );
					pw.println(data); 
					// ln으로 개행 붙여서 전송, print만 하면 개행을 붙여줘야함  					
					
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
	
	private static void log(String log) {
		
		System.out.println("[EchoServer]" + log);
		
	}
}
