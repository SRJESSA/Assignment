package ReqResAutomation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import DeserializationPojo.CreateResponsePojo;
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
	   .when().post("api/users").as(CreateResponsePojo.class);
		CreateResponsePojo response = new CreateResponsePojo();
		System.out.println(response.getName());
		System.out.println(response.getJob());
		System.out.println(response.getId());
	}
}
