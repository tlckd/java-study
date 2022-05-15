package chat.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	
	private ChatUser user;
	private Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	List<Writer> listWriters;
	List<ChatUser> userlist; 
	List<OutputStream> listOutput;
	ArrayList<String> usernamelist=new ArrayList<>();
	int mycount=0;
	ObjectOutputStream objectOutput=null;
	ObjectInputStream objectInput=null;
	
	ChatServerThread(Socket socket, List<Writer> listWriters,List<ChatUser> userlist,List<OutputStream> listOutput){
		this.socket=socket;
		this.listWriters =listWriters;
		this.userlist=userlist;
		this.listOutput = listOutput;
	}

	@Override
	public void run() {
		try {
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		objectOutput = new ObjectOutputStream(socket.getOutputStream());
		objectInput = new ObjectInputStream(socket.getInputStream());
		
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
			System.out.println("문제발생 : " + ex.getMessage());
		}
	}
	

	

	private void doJoin(String name, Writer writer) {

		PrintWriter write = (PrintWriter) writer; 
		
		String data = name + "님이 참여하셨습니다.";
		broadcast(data);
		
		
		//writer pool에 저장.
		addWriter(writer);
		
		//ack 
		printWriter.println("join:ok");
		try {
		Object object = objectInput.readObject();
		user = (ChatUser) object;
		addUserlist(user);
		makeUserList();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

	private void broadcast(String data) {
		
		synchronized(listWriters){
			for( Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);

			}
		}
	}
	
	private void broadcast2(String data) {
		
		synchronized(listWriters){
			for( Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println("userlist:"+data);

			}
		}
	}
	
	private void addUserlist(ChatUser user) {
		synchronized (userlist) {
			userlist.add(user);
		}
	}
	
	private void RemoveuserList() {
		synchronized (userlist) {
			userlist.remove(mycount);
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
				PrintWriter printWriter = (PrintWriter)listWriters.get(i);
				printWriter.println(user.getName()+ ":"+ message);
				//printWriter.flush();
			}
			
		}
		
	}
	
	private void doQuit(Writer writer) {
		RemoveuserList();
		removeWriter(writer);

		//sendUserList();
		
		String data = user.getName() + "님이 퇴장 하셨습니다.";
		broadcast(data);
		makeUserList();
		
	}
	



	public static void log(String log) {
		System.out.println("[ChatServerThread] " + log);
	}
	
	public void makeUserList() {
		synchronized(userlist) {
			try {
				
				if(!usernamelist.isEmpty()) {
					usernamelist.clear();
				}
				for(int i=0; i<userlist.size();i++) {
					String name =userlist.get(i).getName();
					usernamelist.add(name);
				}
				
				for(int i=0; i<userlist.size();i++) {
					userlist.get(i).setList(usernamelist);
				}
				
				broadcast2(String.join(":", usernamelist));
				
				}catch(Exception ex) {
					ex.printStackTrace();
			}
		}
	}
}
