package Assignment;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojo.postCreate;

public class create {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RequestSpecification re= new RequestSpecBuilder().setBaseUri(getUrlValue("baseUrl"))
				.build();
		
 postCreate c= new postCreate();
 c.setName("morpheus");
 c.setJob("leader");
		 Response res= given().log().all().spec(re).body(c).header("Content-Type","application/json")
.when().post("api/users")
.then().log().all().assertThat().statusCode(201).header("Server", "cloudflare")
.extract().response();
             String responseString = res.asString();
             System.out.println(responseString);
	

}
	
	public static String getUrlValue(String key) throws IOException
	{
	Properties pr =new Properties();
	FileInputStream fl =new FileInputStream("C:\\Users\\Shamshad\\eclipse-workspace\\DEMO\\src\\resources\\url.properties");
	pr.load(fl);
	return pr.getProperty(key);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}