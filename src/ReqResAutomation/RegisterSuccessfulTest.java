package ReqResAutomation;

import static io.restassured.RestAssured.given;
import Resources.BaseUrl;
import SerializationPojo.RegisterPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterSuccessfulTest {
	public static void main(String[] args) {

		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		RegisterPojo register = new RegisterPojo();
		register.setEmail("eve.holt@reqres.in");
		register.setPassword("pistol");
		Response res = given().spec(req_spec)
	   .body(register).header("Content-Type", "application/json")
	   .when().post("api/register")
	   .then().assertThat()
	   .statusCode(200).header("Server", "cloudflare")
	   .extract().response();
		String responseString = res.asString();
		System.out.println(responseString);
		System.out.println(register.getEmail());
		System.out.println(register.getPassword());

		JsonPath js = new JsonPath(responseString);
		js.getString("id");
		String registerID = js.getString("id");
		System.out.println(registerID);

//Register Unsuccessful API

		given().spec(req_spec).body("{\r\n" + " \"email\": \"sydney@fife\"\r\n" + "}")
		.header("Content-Type", "application/json").when().post("api/register")
		.then().assertThat()
		.statusCode(400);
	}
}
