package jp.co.internous.lion.model.domain.dto;

import java.sql.Timestamp;

public class CartDto {

	/* tbl_cart.id */
	private int id;
	/* mst_product.image_full_path */
	private String imageFullPath;
	/* mst_product.product_name */
	private String productName;
	/* mst_product.price */
	private int price;
	/* tbl_cart.product_count */
	private int productCount;
	/* mst_product.price * tbl_cart.product_count */
	private int subtotal;
	/* tbl_cart.created_at */
	private Timestamp createdAt;
	/* tbl_cart.updated_at */
	private Timestamp updatedAt;
	
	public CartDto() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
