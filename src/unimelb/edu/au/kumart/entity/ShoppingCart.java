package unimelb.edu.au.kumart.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String item_id;
	private String item_name;
	private String username;
	private int quantity;
	private int price;
	private Date createTime;
	private Date modifiedTime;
	public String getItem_id() {
		return item_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
