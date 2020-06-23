package ReqResAutomation;

	import static io.restassured.RestAssured.given;
	import Resources.BaseUrl;
	import SerializationPojo.LoginPojo;
	import io.restassured.builder.RequestSpecBuilder;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class LoginTest {
		public static void main(String[] args) {

			RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
			LoginPojo login = new LoginPojo();
			login.setEmail("eve.holt@reqres.in");
			login.setPassword("cityslicka");
			Response response = given().spec(req_spec)
		   .body(login).header("Content-Type", "application/json")
		   .when().post("api/login")
		   .then().assertThat()
		   .statusCode(200).header("Server", "cloudflare")
		   .extract().response();
			String responseString = response.asString();
			System.out.println(responseString);
			System.out.println(login.getEmail());
			System.out.println(login.getPassword());

			JsonPath js = new JsonPath(responseString);
			js.getString("token");
			String getToken = js.getString("token");
			System.out.println(getToken);
		}

	//Login Unsuccessful API
			
	  public void main() {	
				
			 RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
             given().spec(req_spec)
			.body("{\r\n" + " \"email\": \"peter@klaven\"\r\n" + "}")
			.when().post("api/login")
			.then().assertThat()
			.statusCode(400);
		}
	}
