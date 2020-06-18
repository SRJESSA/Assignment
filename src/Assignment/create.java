package Assignment;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.postCreate;
import static io.restassured.RestAssured.given;

public class create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();
		
 postCreate c= new postCreate();
 c.setName("morpheus");
 c.setJob("leader");
		 String res= given().log().all().spec(re).body(c).header("Content-Type","application/json")
.when().post("api/users")
.then().log().all().assertThat().statusCode(201).header("Server", "cloudflare")
.extract().response().asString();
		 System.out.println(res);
		 
		 JsonPath js= new JsonPath(res);
		 js.getString("id");
		 String getID =js.getString("id");
		 System.out.println(getID);
		 
		 
		 
		 
		 
           
}

	}


