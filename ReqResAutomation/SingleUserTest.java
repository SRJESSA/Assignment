package ReqResAutomation;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import DeserializationPojo.GetUserResponsePojo;
import Resources.BaseUrl;

public class SingleUserTest {
	public static void main(String[] args) {

		SingleUserTest.single_user_data();
		SingleUserTest.single_user_not_found();
	}
	private static void single_user_data() {
		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		GetUserResponsePojo single_user = given().spec(req_spec)
	   .when().get("api/users/2").as(GetUserResponsePojo.class);
		System.out.println(single_user.getData().getId());
		System.out.println(single_user.getData().getEmail());
		System.out.println(single_user.getData().getFirstName());
		System.out.println(single_user.getData().getLastName());
		System.out.println(single_user.getData().getAvatar());
		System.out.println(single_user.getAd().getCompany());
		System.out.println(single_user.getAd().getText());
		System.out.println(single_user.getAd().getUrl());
	}
	
	private static void single_user_not_found() {

		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		given().spec(req_spec)
	   .when().get("api/users/23")
	   .then().assertThat()
	   .statusCode(404);
	}
}
