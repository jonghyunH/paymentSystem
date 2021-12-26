package com.payment.model;

public class ProductDto {
	private int product_id;
	private String title;
	private int price;
	private String image;
	private String created_at;
	private String modified_at;
	public ProductDto() {
		super();
	}
	public ProductDto(int product_id, String title, int price, String image, String created_at, String modified_at) {
		super();
		this.product_id = product_id;
		this.title = title;
		this.price = price;
		this.image = image;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
		return "ProductDto [product_id=" + product_id + ", title=" + title + ", price=" + price + ", image=" + image
				+ ", created_at=" + created_at + ", modified_at=" + modified_at + "]";
	}
	
	
}
