package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FirstAPITest {
	@Test
  public void testGoogleGetPlaceAPI() {
	  RestAssured.baseURI="https://maps.googleapis.com";
	  //given block will be used to send Headers,Parameters,Cookies,Body
	  given().
		  param("location","-33.8670522,151.1957362").
		  param("radius","500").
		  param("type","restaurant").
		  param("cruise","cruise").
		  param("key","AIzaSyDxUnpGB3qtPt0GEKPbFWMz0nMMmOc-7f8");
	  	//header("key","value").
	  	//cookie("key","value").
	  	//body();
	  
	  //when block will be used to send the resource and the type of HTTP method
	  when().
	  	get("/maps/api/place/nearbysearch/json").	  
	  	then().assertThat().statusCode(200).and().
	  	contentType(ContentType.JSON).and().
	  	body("results[]",equalTo("-33.8675921"));
	  //.and().body("We can validate on a second object and so on so forth").and().
	  //header("key","value"); validating also on response header
	  	//Then block will be receiving the response where the assertions will be performed


	  
	  	
  }

}
