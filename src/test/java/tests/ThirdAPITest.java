package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ThirdAPITest {
	@Test
  public void testGoogleGetPlaceAPI() {
		//BaseURL
	  RestAssured.baseURI="http://216.10.245.166";
	    //Parameters
	  given().
	   	//In post request we have to define the type of parameters  and only key query parameter
	  	//Are only allowed to be sent on the POST API end point.
		  queryParam("key"," qaclick123").
		  body("{\"location\":"
		  		+ "{\"lat\":-38.383494,"
		  		+ "\"lng\":33.427362},"
		  		+ "\"accuracy\":50,"
		  		+ "\"name\":"
		  		+ "\"Frontline house\","
		  		+ "\"phone_number\":"
		  		+ "\"(+91) 983 893 3937\""
		  		+ ",\"address\":"
		  		+ "\"29, side layout, cohen 09\","
		  		+ "\"types\":"
		  		+ "[\"shoe park\",\"shop\"],"
		  		+ "\"website\":"
		  		+ "\"http://google.com\","
		  		+ "\"language\":"
		  		+ "\"French-IN\"}").
		//Resources  
	  when().
	  	post("/maps/api/place/add/json").	  
	  	
	  	//Asserting on Response Code
	  	then().assertThat().statusCode(200).and().
	  	//Assert on Response content type and its structure
	  	contentType(ContentType.JSON).and().
	  	body("status",equalTo("OK"));
  }

}
