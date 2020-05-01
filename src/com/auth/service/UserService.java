package com.auth.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.auth.database.DBConnection;
import com.auth.model.CarOwner;
import com.auth.model.Customer;


public class UserService {
		
	
	public String insertCustomer(String type, String email, String password, String contactNo, String firstName, String lastName, String NIC, String address) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			String query = " insert into customer (`id`,`type`,`email`,`password`,`contactNo`,`firstName`,`lastName`,`NIC`,`address`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, password);
			preparedStmt.setString(5, contactNo);
			preparedStmt.setString(6, firstName);
			preparedStmt.setString(7, lastName);
			preparedStmt.setString(8, NIC);
			preparedStmt.setString(9, address);

			
			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String insertCarOwner(String type, String email, String password, String contactNo, String firstName, String lastName, String NIC, String address, String regNo, String model) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			String query = " insert into carowner (`id`,`type`,`email`,`password`,`contactNo`,`firstName`,`lastName`,`NIC`,`address`,`regNo`,`model`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, password);
			preparedStmt.setString(5, contactNo);
			preparedStmt.setString(6, firstName);
			preparedStmt.setString(7, lastName);
			preparedStmt.setString(8, NIC);
			preparedStmt.setString(9, address);
			preparedStmt.setString(10, regNo);
			preparedStmt.setString(11, model);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readCustomer() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>ID</th><th>User type</th><th>Doctor Email</th><th>Password</th><th>Contact no"
					+ "</th><th>First name</th><th>Last name</th><th>NIC</th><th>address</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("ID"));
				String type = rs.getString("type");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contactNo = rs.getString("contactNo");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String NIC = rs.getString("NIC");
				String address = rs.getString("address");
				
				// Add into the html table
				output += "<tr><td>" + ID + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + contactNo + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + NIC + "</td>";
				output += "<td>" + address + "</td>";				
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"doctor.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + ID + "\">" + "</form></td></tr>";
			}
			con.close();
			
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readCarOwner() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>ID</th><th>Email</th><th>Password</th><th>Contact no"
					+ "</th><th>First name</th><th>Last name</th><th>NIC</th><th>address</th><th>Type</th><th>regNo</th><th>model</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from carowner";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("ID"));
				String type = rs.getString("type");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contactNo = rs.getString("contactNo");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String NIC = rs.getString("NIC");
				String address = rs.getString("address");
				String regNo = rs.getString("regNo");
				String model = rs.getString("model");
				
				// Add into the html table
				output += "<tr><td>" + ID + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + contactNo + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + NIC + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + regNo + "</td>";
				output += "<td>" + model + "</td>";
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"doctor.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + ID + "\">" + "</form></td></tr>";
			}
			con.close();
			
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updateCustomer(String ID, String contactNo) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			// create a prepared statement
			String query = "UPDATE customer SET contactNo=? " 
			+ "WHERE ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
//			preparedStmt.setString(1, password);
			preparedStmt.setString(1, contactNo);
			preparedStmt.setInt(2, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updateCarOwner(String ID, String contactNo) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			// create a prepared statement
			String query = "UPDATE carowner SET contactNo=? " 
			+ "WHERE ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
//			preparedStmt.setString(1, password);
			preparedStmt.setString(1, contactNo);
			preparedStmt.setInt(2, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String deleteCustomer(String ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			
			// create a prepared statement
			String query = "delete from customer "
					+ "where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String deleteCarOwner(String ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from carowner "
					+ "where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	
	// Get Customer data by ID
	public Customer getCustomerById(String aId) {

		Customer rental = new Customer();

		try {
			Connection con = DBConnection.connect();

			String query = "select * from customer where id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(aId));

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				rental.setID(Integer.parseInt(aId));
				rental.setFirstName("firstName");
				rental.setLastName("lastName");
				rental.setAddress("address");
				rental.setNIC("nic");
				rental.setContactNo("contactNo");
				rental.setEmail("email");
				rental.setPassword("password");
				rental.setType("type");
				
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rental;
	}
	
	
	// Get Customer data by ID
	public CarOwner getCarOwnerById(String aId) {

		CarOwner auth = new CarOwner();

		try {
			Connection con = DBConnection.connect();

			String query = "select * from carowner where id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(aId));

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				auth.setID(Integer.parseInt(aId));
				auth.setFirstName("firstName");
				auth.setLastName("lastName");
				auth.setAddress("address");
				auth.setNIC("nic");
				auth.setContactNo("contactNo");
				auth.setEmail("email");
				auth.setPassword("password");
				auth.setType("type");
				auth.setRegNo("regNo");
				auth.setModel("model");
				
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return auth;
	}
	
	
}
