package ReqResAutomation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import Resources.BaseUrl;
import SerializationPojo.CreateUserPojo;

public class CreateIdTest {
	public static void main(String[] args) {

		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		CreateUserPojo user = new CreateUserPojo();
		user.setName("morpheus");
		user.setJob("leader");
		given().spec(req_spec)
	   .body(user).header("Content-Type", "application/json")
	   .when().post("api/users").as(CreateUserPojo.class);
		System.out.println(user.getName());
		System.out.println(user.getName());
	}
}
