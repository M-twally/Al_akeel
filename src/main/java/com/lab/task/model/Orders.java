package com.lab.task.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Runner extends User{
	private boolean status;
	private float delivery_fees;

	@OneToMany(mappedBy = "RunnerData",fetch = FetchType.EAGER)
	private Set<Orders> orders;

	public Runner() {}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDelivery_fees() {
		return delivery_fees;
	}
	public void setDelivery_fees(float delivery_fees) {
		this.delivery_fees = delivery_fees;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}



}