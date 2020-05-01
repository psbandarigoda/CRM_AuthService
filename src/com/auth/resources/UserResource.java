package com.auth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.auth.model.CarOwner;
import com.auth.model.Customer;
import com.auth.service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/users")
public class UserResource {

	UserService userService = new UserService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Doctor> getDoctors() {
//		return userService.getAlldoctors();
//	}
	
	@POST
	@Path("/addCustomer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(@FormParam("firstName") String firstName,
							 @FormParam("lastName") String lastName,
							 @FormParam("address") String address,
							 @FormParam("NIC") String NIC,
							 @FormParam("type") String type,
							 @FormParam("password") String password,
							 @FormParam("email") String email,
							 @FormParam("contactNo") String contactNo){
		String output = userService.insertCustomer(type, email, password, contactNo, firstName, lastName, NIC, address);
		return output;
	}
	
	
	@POST
	@Path("/addCarOwner")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCarOwner(@FormParam("firstName") String firstName,
							 @FormParam("lastName") String lastName,
							 @FormParam("address") String address,
							 @FormParam("NIC") String NIC,
							 @FormParam("password") String password,
							 @FormParam("email") String email,
							 @FormParam("contactNo") String contactNo,
							 @FormParam("type") String type,
							 @FormParam("regNo") String regNo,
							 @FormParam("model") String model){
		String output = userService.insertCarOwner(type, email, password, contactNo, firstName, lastName, NIC, address, regNo, model);
		return output;
	}
	
	
	@GET
	@Path("/getAllCustomers")
	@Produces(MediaType.TEXT_HTML)
	public String readCustomer() {
		return userService.readCustomer();
	}
	
	
	@GET
	@Path("/getAllCarOwners")
	@Produces(MediaType.TEXT_HTML)
	public String readCarOwner() {
		return userService.readCarOwner();
	}
	

	@PUT
	@Path("/updateCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject customerObject = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object
		String ID = customerObject.get("ID").getAsString();
//		String password = doctorObject.get("password").getAsString();
		String contactNo = customerObject.get("contactNo").getAsString();
		
		String output = userService.updateCustomer(ID, contactNo);
		return output;
	}
	
	
//	@PUT
//	@Path("/updateCustomer")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String updateCarOwner(String doctorData) {
//		// Convert the input string to a JSON object
//		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject();
//		// Read the values from the JSON object
//		String ID = doctorObject.get("ID").getAsString();
////		String password = doctorObject.get("password").getAsString();
//		String contactNo = doctorObject.get("contactNo").getAsString();
//		
//		String output = userService.updateCarOwner(ID, contactNo);
//		return output;
//	}
	
	
	// delete Appointment
	@DELETE
	@Path("/removeCustomer/{id}")
	public String deleteCustomer(@PathParam("id") String id) {
		String output = userService.deleteCustomer(id);
		return output;
	}
	
	
	// delete Appointment
	@DELETE
	@Path("/removeCarOwner/{id}")
	public String deleteCarOwner(@PathParam("id") String id) {
		String output = userService.deleteCarOwner(id);
		return output;
	}
	

	// Get Appointment By Id
	@GET
	@Path("/getCustomerById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerById(@PathParam("id")String id) {
		Customer carowner = userService.getCustomerById(id);
		return carowner;
	}
	
	
//	// Get Appointment By Id
//	@GET
//	@Path("/getCarOwnerById/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public CarOwner getCarOwnerById(@PathParam("id")String id) {
//		CarOwner carowner = userService.getCarOwnerById(id);
//		return carowner;
//	}
	
}
