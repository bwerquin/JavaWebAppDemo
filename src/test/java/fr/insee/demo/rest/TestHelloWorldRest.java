package fr.insee.demo.rest ;

import static com.jayway.restassured.RestAssured.expect;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

public class TestHelloWorldRest {
	

    @Test
    public void getMessageByRest() {
        
        // Trying to reach http://localhost:8080/javaWebApp/api/messaging/message with Status = 200
        String message = expect()
                .statusCode(200)
                .contentType(MediaType.TEXT_HTML)
                .when()
                .get("/javaWebApp/api/messaging/message")
                .body()
                .asString();
        assertEquals(message, "Hey !");
    }

    
    @Test
    public void get404() {
        
        // Trying to reach http://localhost:8080/javaApi/api/wrong-url with Status = 404
       expect()
                .statusCode(404)
                .contentType(MediaType.TEXT_HTML)
                .when()
                .get("/javaApi/api/wrong-url")
                .body()
                .asString();
       
    }
    
}
