package chat;

import java.io.BufferedReader;

public class ChatClientThread extends Thread {
	
	private BufferedReader bufferedReader;
	
	@Override
	public void run() {
		String message;
		try {
			while((message=bufferedReader.readLine())!=null) {
				System.out.println(message);
			}
		}catch(Exception e) {
			
		}
	}

	public ChatClientThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	
	
}
