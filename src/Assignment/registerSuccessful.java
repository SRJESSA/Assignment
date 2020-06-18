package Assignment;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.postRegister;

public class registerSuccessful {

	public static void main(String[] args) {

			RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();
		
 postRegister pr= new postRegister();
 pr.setEmail("eve.holt@reqres.in");
 pr.setPassword("pistol");
 Response res= given().log().all().spec(re).body(pr).header("Content-Type","application/json")
.when().post("api/register")
.then().log().all().assertThat().statusCode(200).header("Server", "cloudflare")
.extract().response();
             String responseString = res.asString();
             System.out.println(responseString);

JsonPath js= new JsonPath(responseString);
js.getString("id");
String registerID =js.getString("id");
System.out.println(registerID);


//Register Unsuccessful API

given().log().all().spec(re)
.body("{\r\n" + 
		"    \"email\": \"sydney@fife\"\r\n" + "}")
.header("Content-Type","application/json")
.when().post("api/register")
.then().log().all().assertThat().statusCode(400);

	

}
}