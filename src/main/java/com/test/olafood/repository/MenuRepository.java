package com.test.olafood.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.olafood.domain.Menu;
import com.test.olafood.domain.Restaurant;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long>{
	
	List<Menu> findByRestaurant(Restaurant rest);
	Menu findByMenuId(Long id);

}
