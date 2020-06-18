package Assignment;
	import static io.restassured.RestAssured.given;
	import io.restassured.builder.RequestSpecBuilder;
    import io.restassured.specification.RequestSpecification;
	import static org.hamcrest.Matchers.*;

	
	public class singleUser{
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		{
	RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
					.build();

	
	String response =given().log().all().spec(re)
	.when().get("api/users/2")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
		
	   given().log().all().spec(re)
		.when().get("api/users/2")
		.then().log().all().assertThat().statusCode(200)
		  .body("data.first_name", equalTo("Janet"),"data.last_name", equalTo("Weaver"),"ad.company", equalTo("StatusCode Weekly"));
	
	   
//Single User Not Found API
	   
		given().log().all().spec(re)
		.when().get("api/users/23")
		.then().log().all().assertThat().statusCode(404);
	
	
	

		}

	}
	}


