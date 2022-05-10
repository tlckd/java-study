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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
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
				//System.out.println("clicked!");
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

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// System.exit(0);
				// 종료시켯을떄 할 작업들 지정 
				finish();
			}

		});
		frame.setVisible(true);
		frame.pack();
	
		/*
		 * 2. IO 스트림 (파이프라인 작업 (보조랑 연계하는거 ㅇㅇ ) 
		 * 
		 * */
		
		/*3.
		 * 쳇 클라 스레드 생성하고 실행 
		 */
		
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println(" 메세지 보내는 프로토콜 구현 : " + message);
		textField.setText("");
		textField.requestFocus();
		
		updateTextArea("마이콜:"+message);
	}
	
	private void updateTextArea (String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	

	private void finish() {
		// TODO Auto-generated method stub
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현");
		System.exit(0); //0은 정상종료
		//quit 을 안보네도 보낸것처럼 처리해야함
		//0말고 다른거 리턴해주면 에러임 비정상 종료했을때도 ~님이 나갔습니다. 출력가능하게 만들기 
		
	}
	
	
	
	//스레드는 밖에 만들지말고 내부클래스를 사용 
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			//메시지 왔으면 while문해서 소켓받아서 버퍼드리더로 온 메시지를 읽으면 됨 
			//String message = "둘리:안녕";
			//updateTextArea(message);
			//sendMessage();
		}	
	}
}
