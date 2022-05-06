package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			
			
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			String request = null;
			
			while(true) {
				
				String line = br.readLine();
				
				
				//브라우저가 연결을 끊으면,
				if(line==null) {
					break;
				}
				
				//SimpleHttpServer는 요청 헤더만 읽음
				if("".equals(line)) { // 바디가 시작되는 부분 
					break; //바디가 시작되면 break
				}
				
				//헤더의 첫 번째 라인만 읽음 
				if(request==null) {
					request=line;
					break;
				}
					
			}
			
			// 요청 처리 
			// consoleLog(request);
			
			//토큰분리 스페이스를 구분자로 분리한다.
			String[] tokens =request.split(" ");// 스페이스로 구분자 되어있는건 규약
			
			if("GET".equals(tokens[0])) { //GET만 처리
				consoleLog("request:" + tokens[1]); //1 요청 URL 
				//응답 
				responseStaticResource(outputStream, tokens[1], tokens[2]); // / HTTP =>  url 경로와 프로토콜 인자로 넣어줌
			}else {
				
				// method: POST, PUT, DELETE, HEAD, CONNECT 
				// SimpleHttpServer 에서는 무시(400 Bad Request 응답)
				// 이것도 과제 ㅇㅇ 
				response400Error(outputStream, tokens[1],tokens[2]);
			}
			
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) ); // 헤더부분 
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
			
			
			
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}


	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// welcom file set
		if("/".equals(url)){
			url="/index.html";
			
		}
		
		File file = new File("./webapp" + url); // 파일 읽음 
		if(!file.exists()) {
			response404Response(outputStream,url,protocol); //과제 404 응답이 가능하게 
			return; 
			
		}
		
		// nio (new io) -> 좀더 편하게 스트림 읽을 수 있음 
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType =Files.probeContentType(file.toPath());// 컨텐츠 타입을 리턴 
		//response 
		outputStream.write( (protocol+ " 200 OK\r\n").getBytes( "UTF-8" ) ); // 헤더부분 프로토콜하고 한칸띄우고 하는게 규약임 
		outputStream.write( ("Content-Type:"+ contentType + "; charset=utf-8\n").getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes());
		//여기부터 바디
		outputStream.write( body );
	
	}

	

	private void response400Error(OutputStream outputStream, String url, String protocol) {
		/*
		 * HTTP/1.1 400 Bad Request
		 * Content-type:text/html; charset=utf-8\n
		 * \n 
		 *  /error/400.html 
		 * 이 내용을 보내라 
		 * 
		 */
		try {
			File file = new File("./webapp/error/400.html");
			byte[] body = Files.readAllBytes(file.toPath());
			String contentType =Files.probeContentType(file.toPath());
			
			outputStream.write( (protocol+ " 400 Bad Request\r\n").getBytes( "UTF-8" ) );
			outputStream.write( ("Content-Type:"+ contentType + "; charset=utf-8\n").getBytes( "UTF-8" ) );
			outputStream.write( "\n".getBytes());
			
			outputStream.write( body );
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		
		
		
	}
	
	
	private void response404Response(OutputStream outputStream, String url, String protocol) {
		/*
		 * HTTP/1.1 404 File Not Found
		 * Content-type:text/html; charset=utf-8\n
		 * \n 
		 *  /error/404.html 
		 * 이 내용을 보내라 
		 * 
		 */
		try {
			File file = new File("./webapp/error/404.html");
			byte[] body = Files.readAllBytes(file.toPath());
			String contentType =Files.probeContentType(file.toPath());
			
			outputStream.write( (protocol+ " 404 File Not Found\r\n").getBytes( "UTF-8" ) );
			outputStream.write( ("Content-Type:"+ contentType + "; charset=utf-8\n").getBytes( "UTF-8" ) );
			outputStream.write( "\n".getBytes());
			
			outputStream.write( body );
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
