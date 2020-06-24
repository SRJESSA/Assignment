package ReqResAutomation;

import static io.restassured.RestAssured.given;
import DeserializationPojo.ListUsersResponsePojo;
import Resources.BaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ListUsersTest {
	public static void main(String[] args) {

		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		ListUsersResponsePojo list_users = given().spec(req_spec).queryParam("page", "2")
	   .when().get("api/users?page=2").as(ListUsersResponsePojo.class);
		System.out.println(list_users.getPage());
		System.out.println(list_users.getPerPage());
		System.out.println(list_users.getTotal());
		System.out.println(list_users.getTotalPages());
		System.out.println(list_users.getData().get(0).getId());
		System.out.println(list_users.getData().get(1).getFirstName());
		System.out.println(list_users.getData().get(2).getLastName());
		System.out.println(list_users.getData().get(3).getAvatar());
		System.out.println(list_users.getData().get(4).getId());
		System.out.println(list_users.getData().get(5).getFirstName());
		System.out.println(list_users.getAd().getCompany());
		System.out.println(list_users.getAd().getText());
		System.out.println(list_users.getAd().getUrl());
	}
}
