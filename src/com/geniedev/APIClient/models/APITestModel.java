package com.geniedev.APIClient.models;


import com.google.gson.annotations.*;
import com.geniedev.APIClient.utils.Model;


public class APITestModel extends Model {
	
	@Expose(serialize = false)
	public int id;
	
	@Expose
	public String name;
	
	@Expose
	public String phone;
	
	
	/**
	 * As it appears in the Database
	 */
	public String getApiName() { return "APITestModel"; }
	
	/**
	 * Fields to be listed,
	 * '*' for all fields.
	 */
	public String getFields() {return "*"; }
	
	/**
	 * Primary key of this Model
	 */
	public int getId() { return this.id; }
	
	/**
	 * Set primary key to this object
	 * (Must be included, used by the Client).
	 */
	public void setId(int id) { this.id = id; }
	
	/**
	 * Primary Key as it appears in the Database
	 */
	public String getIdName() { return "id"; }
	
}
