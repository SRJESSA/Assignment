package Assignment;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class singleResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();

ResponseSpecification rs =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
.build();


given().log().all().spec(re)
.when().get("api/unknown/2")
.then().log().all().assertThat().statusCode(200)
  .body("data.id", equalTo(2),"data.name", equalTo("fuchsia rose"),"data.year",equalTo(2001),"ad.company", equalTo("StatusCode Weekly"));






given().log().all().spec(re)
.when().get("api/unknown/23")
.then().log().all().assertThat().statusCode(404);


	}

}
