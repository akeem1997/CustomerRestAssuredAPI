package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.CustomerEndpoint;
import api.payload.Customer;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority = 1,dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostCustomer(String id, String nam, String mail, String loc) {
		Customer userpayload = new Customer();
		userpayload.setId(Integer.parseInt(id));
		userpayload.setName(nam);
		userpayload.setEmail(mail);
		userpayload.setLocation(loc);
		Response res = CustomerEndpoint.CreateCustomer(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 201);
		
	}
	
	@Test(priority = 2, dataProvider = "id", dataProviderClass = DataProviders.class)
	public void getCustomer(String id) {
		Response res = CustomerEndpoint.getCustomer(Integer.parseInt(id));
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}

}
