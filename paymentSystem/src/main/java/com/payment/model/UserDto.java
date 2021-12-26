package com.payment.model;

public class UserDto {
	private int user_id;
	private String name;
	private String password;
	private String email;
	private String created_at;
	private String modified_at;
	
	
	public UserDto() {
		super();
	}

	public UserDto(int user_id, String name, String password, String email, String created_at, String modified_at) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getModified_at() {
		return modified_at;
	}

	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}

	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", created_at=" + created_at + ", modified_at=" + modified_at + "]";
	}
	
}
