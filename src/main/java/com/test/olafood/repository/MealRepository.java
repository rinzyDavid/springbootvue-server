package com.test.olafood.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.olafood.domain.Meal;
import com.test.olafood.domain.Menu;

@Repository
public interface MealRepository extends CrudRepository<Meal,Long>{
	
	List<Meal> findByMenu(Menu menu);
	Meal findByMealId(Long id);

}
