package com.test.olafood.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.olafood.domain.City;

@Repository
public interface CityRepository extends CrudRepository<City,Long>{
	
	List<City> findByCityName(String name);
	List<City> findByCityNameContainingIgnoringCase(String cityName);

}
