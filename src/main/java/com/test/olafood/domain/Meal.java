package com.test.olafood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="meal")
public @Data class Meal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mealId;
	
	private String name;
	private String pictureUrl;
	private Double price;
	private String timeToPepare;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	@OneToOne
	@JoinColumn(name="menuId")
	private Menu menu;

}
