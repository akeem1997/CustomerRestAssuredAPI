package api.endpoints;

public class Routes {
	
	public static String base_Url = "http://restapi.adequateshop.com";
	
	//Get all customers
	public static String Get_All_Customers = base_Url+"/api/Customer";
	public static String Post_customers = base_Url+"/api/Customer";
	public static String Get_Single_customer = base_Url+"/api/Customer/{id}";
	public static String delete_customer = base_Url+"/api/Customer/{id}";
	public static String Update_customer = base_Url+"/api/Customer/{id}"; 
	

}
