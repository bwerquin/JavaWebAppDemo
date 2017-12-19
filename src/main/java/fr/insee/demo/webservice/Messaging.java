package fr.insee.demo.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.insee.demo.model.Discussion;
import fr.insee.demo.model.HelloWorld;
import fr.insee.demo.model.User;
import fr.insee.demo.persistence.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/messaging")
@Api(value = "Messaging")
public class Messaging {

	@Autowired
	private QueryService messageService;

	@GET
	@Path("message/{id}")
	@Produces(MediaType.TEXT_HTML)
	@ApiOperation(value = "Get Message", notes = "Gets the message with id {id}", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not found") })
	public Response getMessageById(
			@ApiParam(value = "This is the id of the object we want to retrieve", required = true) @PathParam(value = "id") String id)
			throws Exception {
		try {
			String result = messageService.getMessageByID(id);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			throw e;
		}

	}

	@GET
	@Path("message")
	@Produces(MediaType.TEXT_HTML)
	@ApiOperation(value = "Get message", notes = "Get simple message from Helloworld model")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Unexpected error") })
	public String getMessage() throws Exception {
		HelloWorld hello = new HelloWorld("Hey !");
		return hello.getMessage();
	}

	@GET
	@Path("discussion")
	@Produces(MediaType.TEXT_HTML)
	@ApiOperation(value = "Get discussion", notes = "Get simple conversation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Unexpected error") })
	public String getConversation() throws Exception {
		User user1 = new User("001", "John");
		User user2 = new User("001", "Jack");
		Discussion discussion = new Discussion();
		HelloWorld hello = new HelloWorld("Hey John!");
		hello.setUser(user2);
		discussion.AddMessage(hello);
		HelloWorld hello2 = new HelloWorld("Hi Jack!");
		hello2.setUser(user1);
		discussion.AddMessage(hello2);
		HelloWorld hello3 = new HelloWorld("How are you ?");
		hello3.setUser(user1);
		discussion.AddMessage(hello3);
		HelloWorld hello4 = new HelloWorld("Fine, Thx, and you John, how are you ?");
		hello4.setUser(user2);
		discussion.AddMessage(hello4);
		HelloWorld hello5 = new HelloWorld("Fine, Thx.");
		hello5.setUser(user1);
		discussion.AddMessage(hello5);
		return discussion.getAllDiscussion();
	}

}
