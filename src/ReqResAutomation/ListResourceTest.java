  package ReqResAutomation;
  import static io.restassured.RestAssured.given;
  import DeserializationPojo.ListResourcePojo;
  import Resources.BaseUrl;
  import io.restassured.builder.RequestSpecBuilder;
  import io.restassured.specification.RequestSpecification;


  public class ListResourceTest 
  {
    public static void main(String[] args)
    {
			
	RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri(BaseUrl.baseUri()).build();
    ListResourcePojo list_res = given().spec(req_spec)
   .when().get("api/unknown").as(ListResourcePojo.class);
    System.out.println(list_res.getPage());
    System.out.println(list_res.getPer_page());
    System.out.println(list_res.getTotal());
    System.out.println(list_res.getTotal_pages());
    System.out.println(list_res.getData().get(0).getId());
    System.out.println(list_res.getData().get(1).getName());
    System.out.println(list_res.getData().get(2).getYear());
    System.out.println(list_res.getData().get(3).getColor());
    System.out.println(list_res.getData().get(3).getPantone_value());
    System.out.println(list_res.getData().get(4).getId());
    System.out.println(list_res.getData().get(4).getYear());
    System.out.println(list_res.getData().get(5).getPantone_value());
    System.out.println(list_res.getAd().getCompany());
    System.out.println(list_res.getAd().getText());
    System.out.println(list_res.getAd().getUrl());
    
    
   


   }

}


