package ReqResAutomation;

import static io.restassured.RestAssured.given;
import Resources.BaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class ListResourceTest {
	public static void main(String[] args) {

		RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
		given().spec(req_spec)
	   .when().get("api/unknown")
	   .then().assertThat().statusCode(200)
	   .body("page",equalTo(1))
	   .body("perPage",equalTo(6))
	   .body("total",equalTo(12))
	   .body("totalPages",equalTo(2))
       .body("data.Id", hasItems(1, 2, 3, 4, 5,6))
	   .body("data.Name",hasItems("cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise"))
	   .body("data.Year", hasItems(2000, 2001, 2002, 2003, 2004, 2005))
	   .body("data.Color", hasItems("#98B2D1", "#C74375", "#BF1932","#7BC4C4", "#E2583E","#53B0AE"))
	   .body("data.PantoneValue", hasItems(15-4020, 17-2031, 19-1664,14-4811, 17-1456,15-5217));
	}
}
