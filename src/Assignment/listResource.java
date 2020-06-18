package Assignment;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class listResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification re= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.build();


given().log().all().spec(re)
.when().get("api/unknown")
.then().log().all().assertThat().statusCode(200)
.body("data.id[2]", equalTo(3),"data.name[2]", equalTo("true red"))
.body("data.year[3]",equalTo(2003),"data.id[3]",equalTo(4))
.body("data.name[5]",equalTo("blue turquoise"),"data.year[5]",equalTo(2005))
.body("page",equalTo(1),"per_page",equalTo(6) ,"total",equalTo(12),"total_pages",equalTo(2));


	}

}
