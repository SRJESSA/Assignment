package Assignment;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class listUsers {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		
		
		RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();




given().log().all().spec(re).queryParam("page", "2")
.when().get("api/users?page=2")
.then().log().all().assertThat().statusCode(200).header("Server", "cloudflare")
.body("page",equalTo(2),"per_page",equalTo(6) ,"total",equalTo(12),"total_pages",equalTo(2))
.body("data.first_name[0]", equalTo("Michael"),"data.last_name[0]", equalTo("Lawson"))
.body("data.id[1]",equalTo(8),"data.first_name[1]",equalTo("Lindsay"))
.body("ad.company",equalTo("StatusCode Weekly"));


	}

}
