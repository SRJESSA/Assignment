package Assignment;
	import static io.restassured.RestAssured.given;

	import io.restassured.builder.RequestSpecBuilder;
	import io.restassured.builder.ResponseSpecBuilder;
	import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
	import io.restassured.specification.ResponseSpecification;
	import static org.hamcrest.Matchers.*;

	
	public class singleUser{
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		
		{

			RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
					.build();

	ResponseSpecification rs =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
	.build();
	String response =given().log().all().spec(re)
	.when().get("api/users/2")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
		
	   given().log().all().spec(re)
		.when().get("api/users/2")
		.then().log().all().assertThat().statusCode(200)
		  .body("data.first_name", equalTo("Janet"),"data.last_name", equalTo("Weaver"),"ad.company", equalTo("StatusCode Weekly"));
	

		given().log().all().spec(re)
		.when().get("api/users/23")
		.then().log().all().assertThat().statusCode(404);
	
	
	

		}

	}
	}


