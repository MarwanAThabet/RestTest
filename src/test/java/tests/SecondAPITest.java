package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SecondAPITest {
	@Test
  public void testGoogleGetPlaceAPI() {		
		//BaseURL
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//Response Holder
	  Response rawresponse =
	    //Parameters
	  given().
		  param("userId","1").
		//Resources  
	  when().
	  	get("/comments").	  
	  	
	  	
	  	//Asserting on Response Code
	  	then().assertThat().statusCode(200).and().
	  	//Assert on Response content type and its structure
	  	contentType(ContentType.JSON).and().
	  	//Asserting on response Header
	  	header("content-type","application/json; charset=utf-8").and().
		//Asserting on cookie 
	  //cookie("__cfduid","d53c6b712e831ba77ed738a212d88a9c11556828556").and().
	  	//Body Content Validation
	  	body("postId[0]",equalTo(1)).and().
	  	body("id[0]",equalTo(1)).and().
	  	body("name[0]",equalTo("id labore ex et quam laborum")).and().
	  	body("email[0]",equalTo("Eliseo@gardner.biz")).and().
	  	body("body[0]",equalTo("laudantium enim quasi est quidem magnam voluptate ipsam eos\n"
	  			+ "tempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et"
	  			+ " nam sapiente accusantium")).
	  	//Extracting Response
	  	extract().
	  		response();
	  	//Converting the response into a raw stream of string
		String stringresponse = rawresponse.asString();
		//System.out.println(strigresponse);
		
		//Converting the streamed response into a json structured
		JsonPath jsonformat = new JsonPath(stringresponse);
		String thridemail = jsonformat.get("email[2]"); 
		//now you can pass this value into any future requests as a parameter
		//Or insert it inside it inside a body of a POST request using +thridemail+
		System.out.println(thridemail);

		

  }

}
