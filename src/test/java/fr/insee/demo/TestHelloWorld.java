package fr.insee.demo ;

import org.junit.Assert;
import org.junit.Test;

import fr.insee.demo.model.HelloWorld;

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

}
