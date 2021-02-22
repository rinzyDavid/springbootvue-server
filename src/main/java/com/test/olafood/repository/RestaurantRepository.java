package com.test.olafood.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.olafood.domain.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long>{
	
	Restaurant findByRestaurantId(Long id);
	List<Restaurant> findAll();

}
