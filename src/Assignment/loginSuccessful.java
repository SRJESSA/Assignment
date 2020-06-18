package Assignment;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.postLogin;


public class loginSuccessful {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();
		
 postLogin lg= new postLogin();
lg.setEmail("eve.holt@reqres.in");
 lg.setPassword("cityslicka");
 Response response= given().log().all().spec(re).body(lg).header("Content-Type","application/json")
.when().post("api/login")
.then().log().all().assertThat().statusCode(200).header("Server", "cloudflare")
.extract().response();
             String responseString = response.asString();
             System.out.println(responseString);

JsonPath js= new JsonPath(responseString);
js.getString("token");
String getToken =js.getString("token");
System.out.println(getToken);



//Login Unsuccessful API

given().log().all().spec(re)
.body("{\r\n" + 
		"    \"email\": \"peter@klaven\"\r\n" +"}")
.when().post("api/login")
.then().log().all().assertThat().statusCode(400);

	}

}
