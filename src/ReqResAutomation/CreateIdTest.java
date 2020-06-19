  package ReqResAutomation;

  import io.restassured.builder.RequestSpecBuilder;
  import io.restassured.path.json.JsonPath;
  import io.restassured.specification.RequestSpecification;
  import static io.restassured.RestAssured.given;
  import Resources.BaseUrl;
  import SerializationPojo.CreatePojo;

  public class CreateIdTest
  {
    public static void main(String[] args)
    {	
		
	 RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
     CreatePojo create = new CreatePojo();
     create.setName("morpheus");
     create.setJob("leader");
     String response = given().spec(req_spec)
     .body(create)
     .header("Content-Type","application/json")
     .when().post("api/users")
     .then().assertThat()
     .statusCode(201)
     .header("Server", "cloudflare")
     .extract().response().asString();
	 System.out.println(response);
	 System.out.println(create.getName());
	 System.out.println(create.getJob());
	 
	 JsonPath js = new JsonPath(response);
	    js.getString("id");
	    String ID = js.getString("id");
	    System.out.println(ID);
	 
	
		 
		 
		 
		 
    }	 
           
}


