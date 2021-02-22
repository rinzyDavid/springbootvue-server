package com.test.olafood.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="order")
public @Data class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@OneToOne
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant;
	
	private String customerName;
	private String phoneNumber;
	private String email;
	private String orderType; // pickup or delivery
	
	private String deliveryAddress;
	private String orderStatus; // pending,in_transit,completed
	private String paymentStatus; // paid or unpaid
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name="mealId")
	private Meal meal;
	
	
}
