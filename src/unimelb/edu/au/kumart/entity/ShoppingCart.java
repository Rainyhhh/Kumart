package unimelb.edu.au.kumart.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String item_id;
	private String item_name;
	private int user_id;
	private int quantity;
	private Date createTime;
	private Date modifiedTime;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
