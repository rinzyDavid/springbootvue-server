package com.test.olafood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="menu")
public @Data class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long menuId;
	
	private String title;
	@Column(columnDefinition="TEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant;

}
