package com.PresentationLayer.locationWeb.Entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="location")
public class LocationEntity {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocationEntity() {
		
	}
	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + ", getId()="
				+ getId() + ", getCode()=" + getCode() + ", getName()=" + getName() + ", getType()=" + getType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
