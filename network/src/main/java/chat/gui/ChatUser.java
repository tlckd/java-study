package chat.gui;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatUser implements Serializable {
	private String name;
	private ArrayList<String> list;
	
	public ChatUser(String name) {
		super();
		this.name = name;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
