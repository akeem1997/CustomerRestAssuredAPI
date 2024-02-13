package api.tests;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.CustomerEndpoint;
import api.payload.Customer;
import io.restassured.response.Response;

public class CustomerTests {
	
	Faker faker;
	Customer userpayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userpayload = new Customer();
		userpayload.setId(314385);
		userpayload.setName(faker.name().username());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setLocation(faker.address().city());
		
	}
	@Test(priority = 1)
	public void retrieveAllCustomers() {
		Response res = CustomerEndpoint.getAllCustomers();
		res.then().log().all();
		//String LocationName = res.jsonPath().get("[0].location").toString();
		//System.out.println(LocationName);
		//Assert.assertEquals(LocationName, "Shanghai");
		JSONArray ja = new JSONArray(res.asString());
		for(int i=0;i<ja.getJSONObject(i).length();i++) {
			String emails = ja.getJSONObject(i).get("email").toString();
			System.out.println(emails);
			Assert.assertEquals(res.statusCode(), 200);
		}
	}
	@Test(priority = 2)
	public void testPostCustomers() {
		Response res = CustomerEndpoint.CreateCustomer(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 201);
	}
	
	@Test(priority = 3)
	public void GetSingleCustomer() {
		Response res = CustomerEndpoint.getCustomer(this.userpayload.getId());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	

}
