package fr.insee.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Discussion {

	private List<HelloWorld> messages;

	public Discussion() {
		messages = new ArrayList<HelloWorld>();
	}

	public List<HelloWorld> getMessages() {
		return messages;
	}

	public void setMessages(List<HelloWorld> messages) {
		this.messages = messages;
	}

	public void AddMessage(String message) {
		HelloWorld hello = new HelloWorld(message);
		messages.add(hello);
	}

	public void AddMessage(HelloWorld hello) {
		messages.add(hello);
	}

	public String getAllDiscussion() {

		StringBuffer sb = new StringBuffer();
		for (HelloWorld hello : messages) {
			sb.append("\n");
			sb.append(hello.getAuthorName());
			sb.append(" - ");
			sb.append(hello.getMessage());
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getDiscussionsFilterByUserId(String userId) {
		StringBuffer sb = new StringBuffer();
		for (HelloWorld hello : messages) {
			if (userId.equals(hello.getUser().getId())) {
				sb.append("\n");
				sb.append(hello.getAuthorName());
				sb.append(" - ");
				sb.append(hello.getMessage());
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
