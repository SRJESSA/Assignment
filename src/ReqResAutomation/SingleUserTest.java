  package ReqResAutomation;
  
  import static io.restassured.RestAssured.given;
  import io.restassured.builder.RequestSpecBuilder;
  import io.restassured.specification.RequestSpecification;
  import DeserializationPojo.SingleUserPojo;
  import Resources.BaseUrl;

  public class SingleUserTest
  {
     public static void main(String[] args)
     {

     RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
     SingleUserPojo single_user = given().spec(req_spec)
	.when().get("api/users/2").as(SingleUserPojo.class);
     System.out.println(single_user.getData().getId());
     System.out.println(single_user.getData().getEmail());
     System.out.println(single_user.getData().getFirst_name());
     System.out.println(single_user.getData().getLast_name());
     System.out.println(single_user.getData().getAvatar());
     System.out.println(single_user.getAd().getCompany());
     System.out.println(single_user.getAd().getText());
     System.out.println(single_user.getAd().getUrl());
     
     
     
	
//Single User Not Found API
   
	 given().spec(req_spec)
	.when().get("api/users/23")
	.then().assertThat()
	.statusCode(404);

    }
}

