package unimelb.edu.au.kumart.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String item_id;
	private String user_id;
	private int quantity;
	private Date createTime;
	private Date modifiedTime;
	
	
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
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
