package unimelb.edu.au.kumart.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * Model: Item
 * Including all the attributes of an item.
 */
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private String name;
	private String description;
	private int price;
	private int number;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
