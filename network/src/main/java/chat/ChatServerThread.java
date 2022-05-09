package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

public class ChatServerThread extends Thread {
	
	private String nickname;
	private Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	List<Writer> listWriters;
	int mycount=0;
	
	ChatServerThread(Socket socket, List<Writer> listWriters){
		this.socket=socket;
		this.listWriters =listWriters;
	}

	@Override
	public void run() {
		try {
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		
		while(true) {
			String request = bufferedReader.readLine();
			if(request==null) {
				ChatServer.log("클라이언트로 부터 연결 끊김");
				doQuit(printWriter);
				break;
			}

			String[] tokens = request.split(":");
			
			if("join".equals(tokens[0])) {
				doJoin(tokens[1],printWriter);
			}else if("message".equals(tokens[0])) {
				doMessage(tokens[1]);
			}else if("quit".equals(tokens[0])) {
				doQuit(printWriter);
			}else {
				ChatServer.log("에러: 알수 없는 요청 (" + tokens[0] + ")");
			}
			

		}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			doQuit(printWriter);
			
		}
	}
	

	

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		PrintWriter write = (PrintWriter) writer; 
		
		String data = nickName + "님이 참여하셨습니다.";
		broadcast(data);
		
		//writer pool에 저장.
		addWriter(writer);
		
		//ack 
		printWriter.println("join:ok");
		printWriter.flush();
		
	}
	
	private void broadcast(String data) {
		
		synchronized(listWriters){
			for( Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
			mycount = listWriters.size()-1;
		}
		
	}
	
	private void removeWriter(Writer writer) {
		synchronized(listWriters){
			listWriters.remove(mycount);
		}
		
	}
	
	private void doMessage(String message) {
		
		synchronized(listWriters){
			
			for(int i=0 ; i<listWriters.size();i++) {
				if(i==mycount) {
					continue;
				}
				PrintWriter printWriter = (PrintWriter)listWriters.get(i);
				printWriter.println(nickname+ ":"+ message);
				printWriter.flush();
			}
			
		}
		
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장 하셨습니다.";
		broadcast(data);
		
	}
	


	public static void log(String log) {
		System.out.println("[ChatServerThread] " + log);
	}
	
	
}
