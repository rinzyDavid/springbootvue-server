package com.test.olafood.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.olafood.domain.Meal;
import com.test.olafood.domain.Menu;
import com.test.olafood.domain.Order;
import com.test.olafood.domain.Restaurant;
import com.test.olafood.pojo.OrderModel;
import com.test.olafood.service.OlaFoodService;

@CrossOrigin(origins = {"http://localhost:8386","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class OlaFoodsController {
	
	
	@Autowired private OlaFoodService foodservice;
	
	
	@GetMapping("/restaurants/listall")
	public ResponseEntity<List<Restaurant>> listAllrestaurants(){
		
		List<Restaurant> rests = foodservice.listAllRestaurants();
		return new ResponseEntity<>(rests, HttpStatus.OK); 
	}
	
	
	@GetMapping("/searchrestaurant/{cityName}")
	public ResponseEntity<List<Restaurant>> searchRestaurantByCity(@PathVariable("cityName") String cityName){
		try {
			List<Restaurant> rest = foodservice.searchRestaurantbyCity(cityName);
			
				return new ResponseEntity<>(rest, HttpStatus.OK); 
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@GetMapping("/listmenu/{restaurantId}")
	public ResponseEntity<List<Menu>> listMenu(@PathVariable("restaurantId")Long id){
		
		try {
			List<Menu> menus =  foodservice.listRestaurantMenu(id);
			
				return new ResponseEntity<>(menus, HttpStatus.OK); 
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}

	
	@GetMapping("/listmeals/{menuId}")
	public ResponseEntity<List<Meal>> listMealsForMenu(@PathVariable("menuId")Long id){
		
		
		try {
			List<Meal> meals = foodservice.listMenuMeals(id);
		
				return new ResponseEntity<>(meals, HttpStatus.OK); 
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/placeorder")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderModel orderModel){
		
		try {
			Order order =foodservice.placeOrder(orderModel);
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
