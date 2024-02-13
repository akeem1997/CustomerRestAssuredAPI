package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.Customer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CustomerEndpoint {
	
	public static Response getAllCustomers() {
		Response res = when().get(Routes.Get_All_Customers);
		return res;
		
	}
	 public static Response CreateCustomer(Customer payload) {
		 Response res = given().contentType(ContentType.JSON)
				 .accept(ContentType.JSON).body(payload).when().post(Routes.Post_customers);
		 return res;
	 }
	 
	 public static Response updateCustomer(Customer payload,int id) {
		 Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id",id)
				 .body(payload).when().put(Routes.Update_customer);
		 return res;
		 
	 }
	 public static Response deleteCustomer(int id) {
		 Response res = given().pathParam("id",id).when().delete(Routes.delete_customer);
		 return res;
		 
	 }
	 public static Response getCustomer(int id) {
		 Response res = given().pathParam("id",id).when().get(Routes.Get_Single_customer);
		 return res;
		 
	 }
	 

}
