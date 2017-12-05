package fr.insee.demo ;

import org.junit.Assert;
import org.junit.Test;

import fr.insee.demo.model.HelloWorld;
import fr.insee.demo.model.User;

public class TestHelloWorld {
	

	@Test
	public void getMessage() {
		HelloWorld hello = new HelloWorld("Hey !");
		Assert.assertEquals(hello.getMessage(),"Hey !");
	}
	
	@Test
	public void assertNotNullMessage() {
		HelloWorld hello = new HelloWorld("Hey !");
		Assert.assertNotNull(hello.getMessage());
	}

	@Test
	public void getUserFromMessage() {
		User user = new User("001", "John");
		HelloWorld hello = new HelloWorld("Hey !");
		hello.setUser(user);
		Assert.assertEquals(hello.getUser().getId(),"001");
	}
	
	@Test
	public void getAuthor() {
		User user = new User("001", "John");
		HelloWorld hello = new HelloWorld("Hey !");
		hello.setUser(user);
		Assert.assertEquals(hello.getAuthorName(),"John");
	}
	
	@Test
	public void getAuthorWhenNotSpecified() {
		HelloWorld hello = new HelloWorld("Hey !");
		Assert.assertNull(hello.getAuthorName());
	}
	
	
}
