package com.apex.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PRODUCT")
public class Product {

private int id;
private String name;
private double price;

public Product() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
@XmlElement(name="ID")
public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

@XmlElement(name="NAME")
public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

@XmlElement(name="PRICE")
public void setPrice(double price) {
	this.price = price;
}

}
