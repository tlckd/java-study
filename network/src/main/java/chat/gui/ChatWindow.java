package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	
	private Panel pannel2;
	private JList list;
	private JScrollPane scrolled;
	
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String name;
	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	
	public ChatWindow(String name,Socket socket,BufferedReader bufferedReader, PrintWriter printWriter) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name=name;
		this.socket=socket;
		this.bufferedReader = bufferedReader;
		this.printWriter = printWriter;
	}


	public void show() {
		/*
		 * 1. UI 초기화 
		 * 
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) { // 옵저패턴 이벤트를 감시함 
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar(); // 키 코드값 받음
				if(keyCode == KeyEvent.VK_ENTER) { 
					sendMessage();
				}
			}
			
		});
		
		
		
		
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);
		
		//Pannel2 
//		list=new JList("나중에 넣을 내용");
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrolled=new JScrollPane(list);
//		scrolled.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
//		
//		pannel2.add(list);
//		frame.add(BorderLayout.EAST, pannel2);
		
		
		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 종료시켯을떄 할 작업들 지정 
				finish();
			}

		});
		frame.setVisible(true);
		frame.pack();
	
		
		/*3.
		 * 쳇 클라 스레드 생성하고 실행 
		 */
		new ChatClientThread().start();
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		//System.out.println(" 메세지 보내는 프로토콜 구현 : " + message);
		textField.setText("");
		textField.requestFocus();
		if(message.length()==0) {
			message=" ";
		}
		printWriter.println("message:" + message);
		//updateTextArea(bufferedReader.readLine());
	}
	
	private void updateTextArea (String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	

	private void finish() {
		// TODO Auto-generated method stub
		//System.out.println("소켓 닫기 or 방나가기 프로토콜 구현");
		System.exit(0); //0은 정상종료
		printWriter.println("quit:");
	}
	
	
	
	//스레드는 밖에 만들지말고 내부클래스를 사용 
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			String message;
			try {
				
				while((message = bufferedReader.readLine())!=null) {
					System.out.println("읽음" + message);
					updateTextArea(message);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}	
	}
}
