  package ReqResAutomation;
  import static io.restassured.RestAssured.given;
  import DeserializationPojo.SingleResourcePojo;
  import Resources.BaseUrl;
  import io.restassured.builder.RequestSpecBuilder;
  import io.restassured.specification.RequestSpecification;


  public class SingleResourceTest 
  {
     public static void main(String[] args)
     {
		
	 RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
     SingleResourcePojo single_res = given().spec(req_spec)
    .when().get("api/unknown/2").as(SingleResourcePojo.class);
     System.out.println(single_res.getData().getId());
     System.out.println(single_res.getData().getName());
     System.out.println(single_res.getData().getYear());
     System.out.println(single_res.getData().getColor());
     System.out.println(single_res.getData().getPantone_value());
     System.out.println(single_res.getAd().getCompany());
     System.out.println(single_res.getAd().getText());
     System.out.println(single_res.getAd().getUrl());
     
    
   


//Single Resource Not Found API

    given().spec(req_spec)
   .when().get("api/unknown/23")
   .then().assertThat()
   .statusCode(404);


   }

}

