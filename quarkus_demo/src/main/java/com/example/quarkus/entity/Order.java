/**
 * 
 */
package com.example.quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jaydeep.deshmukh
 * Date: 16-Feb-2020
 *
 */
@Entity
@Table(name="order_table")
public class Order extends PanacheEntity{

	public String itemName;
	public String orderBy;
	public String orderDate;
	
	public Order() {
		
	}
	
	public Order(String itemName, String orderBy, String orderDate) {
		super();
		this.itemName = itemName;
		this.orderBy = orderBy;
		this.orderDate = orderDate;
	}
	
	
	
	
}
