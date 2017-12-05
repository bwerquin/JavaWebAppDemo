package fr.insee.demo.model;

public class HelloWorld {

	private User user;
	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthorName() {
		if (user != null) {
			return this.getUser().getName();
		} else {
			return null;
		}
	}

}
