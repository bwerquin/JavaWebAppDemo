package fr.insee.demo.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import fr.insee.demo.model.HelloWorld;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/messaging")
@Api(value = "Messaging")
public class Messaging {
	
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
		HelloWorld hello = new HelloWorld("Hey !");
		return hello.getMessage();
	}
	
}
