package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pageobjects.PayLoads;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FourthAPITestAddingDeleting {
	@Test
	public void testGoogleGetPlaceAPI() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response rawresponse = given().
				queryParam("key","AIzaSyDxUnpGB3qtPt0GEKPbFWMz0nMMmOc-7f8").
				
				body(PayLoads.getGoogleBody()).
				
				when().
					post("/maps/api/place/add/json").
				
				then().
					assertThat().
						statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("status", equalTo("OK")).
						
					extract().response();
		
		String stringresponse = rawresponse.asString();
		System.out.println(stringresponse);
		
		//Converting the streamed response into a json structured
		JsonPath jsonformat = new JsonPath(stringresponse);
		jsonformat.get("email[2]");
		
	}

}
