package fr.insee.demo;

import org.junit.Assert;
import org.junit.Test;

import fr.insee.demo.model.User;

public class TestUser {

	@Test
	public void getName() {
		User user = new User("001", "John");
		Assert.assertEquals(user.getName(), "John");
	}

	@Test
	public void assertNotNullUser() {
		User user = new User("001", "John");
		Assert.assertNotNull(user.getId());
	}

}
