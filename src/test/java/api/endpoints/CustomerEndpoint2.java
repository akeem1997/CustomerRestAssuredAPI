package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.Customer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CustomerEndpoint2 {
	// method created for getting URLS from properties file
	public static ResourceBundle getURL() {
		ResourceBundle  routes = ResourceBundle.getBundle("routes"); //load properties file
		return routes;
	}
	
	
	
	
	public static Response getAllCustomers() {
		String getAll =getURL().getString("get_all_url");
		Response res = when().get(getAll);
		return res;
		
	}
	 public static Response CreateCustomer(Customer payload) {
		String post_url = getURL().getString("post_url");
		 Response res = given().contentType(ContentType.JSON)
				 .accept(ContentType.JSON).body(payload).when().post(post_url);
		 return res;
	 }
	 
	 public static Response updateCustomer(Customer payload,int id) {
		 String update =getURL().getString("update_url");
		 Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id",id)
				 .body(payload).when().put(update);
		 return res;
		 
	 }
	 public static Response deleteCustomer(int id) {
		 String delete =getURL().getString("delete_url");
		 
		 Response res = given().pathParam("id",id).when().delete(delete);
		 return res;
		 
	 }
	 public static Response getCustomer(int id) {
		 String get =getURL().getString("get_url");
		 Response res = given().pathParam("id",id).when().get(get);
		 return res;
		 
	 }
	 

}
