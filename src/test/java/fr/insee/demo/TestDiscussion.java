package fr.insee.demo ;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.insee.demo.model.Discussion;
import fr.insee.demo.model.HelloWorld;
import fr.insee.demo.model.User;

public class TestDiscussion {
	
	private Discussion discussion;
	private Discussion discussionUser1;
	private Discussion discussionUser2;
	
	@Before
	public void initDiscussion(){
		User user1 = new User("001", "John");
		User user2 = new User("001", "Jack");
		discussion = new Discussion();
		discussionUser1 = new Discussion();
		discussionUser2 = new Discussion();
		HelloWorld hello = new HelloWorld("Hey John!");
		hello.setUser(user2);
		discussion.AddMessage(hello);
		discussionUser2.AddMessage(hello);
		HelloWorld hello2 = new HelloWorld("Hi Jack!");
		hello2.setUser(user1);
		discussion.AddMessage(hello2);
		discussionUser1.AddMessage(hello);
		HelloWorld hello3 = new HelloWorld("How are you ?");
		hello3.setUser(user1);
		discussion.AddMessage(hello3);
		discussionUser1.AddMessage(hello);
		HelloWorld hello4 = new HelloWorld("Fine, Thx, and you John, how are you ?");
		hello4.setUser(user2);
		discussion.AddMessage(hello4);
		discussionUser2.AddMessage(hello);
		HelloWorld hello5 = new HelloWorld("Fine, Thx.");
		hello5.setUser(user1);
		discussion.AddMessage(hello5);
		discussionUser1.AddMessage(hello);
		
	}
	

	@Test
	public void getAllDiscussion() {
		Assert.assertEquals(discussion.getAllDiscussion(),discutionToString(discussion));
	}
	
	@Test
	public void getDiscussionsFilterByUser() {
		Assert.assertEquals(discussion.getDiscussionsFilterByUserId("001"),discutionToString(discussionUser1));
	}
	
	@Test
	public void getDiscussionsFilterByUser2() {
		Assert.assertEquals(discussion.getDiscussionsFilterByUserId("002"),discutionToString(discussionUser2));
	}
	
	@Test
	public void assertNotNullMessage() {
		HelloWorld hello = new HelloWorld("Hey !");
		Assert.assertNotNull(hello.getMessage());
	}
	
	
	
	private String discutionToString(Discussion discusionToPrint){
		StringBuffer sb = new StringBuffer();
		for (HelloWorld hello : discusionToPrint.getMessages()){
			sb.append("\n");
			sb.append(hello.getAuthorName());
			sb.append(" - ");
			sb.append(hello.getMessage());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	

}
