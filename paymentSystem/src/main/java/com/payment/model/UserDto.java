package com.payment.model;

public class UserDto {
	private int pk;
	private String name;
	private String password;
	private String email;
	private String create_at;
	private String modified_at;
	
	public UserDto() {
		super();
	}

	public UserDto(int pk, String name, String password, String email, String create_at, String modified_at) {
		super();
		this.pk = pk;
		this.name = name;
		this.password = password;
		this.email = email;
		this.create_at = create_at;
		this.modified_at = modified_at;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
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

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getModified_at() {
		return modified_at;
	}

	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}

	@Override
	public String toString() {
		return "UserDto [pk=" + pk + ", name=" + name + ", password=" + password + ", email=" + email + ", create_at="
				+ create_at + ", modified_at=" + modified_at + "]";
	}
	
	
}
