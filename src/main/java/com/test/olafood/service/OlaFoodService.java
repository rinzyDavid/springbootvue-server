package com.test.olafood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.olafood.domain.*;
import com.test.olafood.pojo.OrderModel;
import com.test.olafood.repository.*;

@Service
public class OlaFoodService {
	
	@Autowired private RestaurantRepository restaurantRepo;
	@Autowired private CityRepository cityRepo;
	@Autowired private MenuRepository menuRepo;
	@Autowired private MealRepository mealRepo;
	@Autowired private OrderRepository orderRepo;
	
	
	// crud operations for restaurant
	//=================================================================
	public Restaurant createOrUpdateRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	
	
	public void deleteRestaurant(Long id) {
		Restaurant rest = restaurantRepo.findByRestaurantId(id);
		restaurantRepo.delete(rest);
	}
	
	public Restaurant getRestaurant(Long id) {
		return restaurantRepo.findByRestaurantId(id);
	}
	
	public List<Restaurant> listAllRestaurants(){
		return restaurantRepo.findAll();
	}
	
public List<Restaurant> searchRestaurantbyCity(String cityName){
		
		List<City> cities = cityRepo.findByCityNameContainingIgnoringCase(cityName);
		List<Restaurant> restaurants = new ArrayList<>();
		
		for(City city : cities) {
			restaurants.add(city.getRestaurant());
		}
		return restaurants;
	}
	
	
	//crud operations for city
	//=====================================================================
	
	public void createCity(City city) {
		cityRepo.save(city);
	}
	
	public void createCity(List<City> cities) {
		cityRepo.saveAll(cities);
	}
	
	
	
	
	//crud operations for menu
	//=======================================================================
	public Menu createMenu(Menu menu) {
		return menuRepo.save(menu);
	}
	
	public void createMenu(List<Menu> menus) {
		menuRepo.saveAll(menus);
	}
	
	public Menu getMenu(Long id) {
		return menuRepo.findByMenuId(id);
	}
	
	public List<Menu> listRestaurantMenu(Long restaurantId){
		
		Restaurant restaurant = getRestaurant(restaurantId);
		return menuRepo.findByRestaurant(restaurant);
	}
	
	//crud operations for meal
	//====================================================================
	
	public void createMeal(Meal meal) {
		mealRepo.save(meal);
	}
	
	public void createMeal(List<Meal> meal) {
		mealRepo.saveAll(meal);
	}
	
	public List<Meal> listMenuMeals(Long menuId){
		
		Menu menu  = getMenu(menuId);
		return mealRepo.findByMenu(menu);
	}
	
	public Meal getMeal(Long id) {
		return mealRepo.findByMealId(id);
	}
	
	//crud operations for order
	//=====================================================================
	
	public Order placeOrder(OrderModel orderModel)
	{
		Restaurant restaurant = getRestaurant(orderModel.getRestaurantId());
		Meal meal = getMeal(orderModel.getMealId());
		
		Order order = new Order();
		order.setCustomerName(orderModel.getCustomerName());
		order.setDeliveryAddress(orderModel.getDeliveryAddress());
		order.setEmail(orderModel.getEmail());
		order.setMeal(meal);
		order.setOrderDate(orderModel.getOrderDate());
		order.setOrderStatus(orderModel.getOrderStatus());
		order.setOrderType(orderModel.getOrderType());
		order.setPaymentStatus(orderModel.getPaymentStatus());
		order.setPhoneNumber(orderModel.getPhoneNumber());
		order.setRestaurant(restaurant);
	Order savedOrder =	orderRepo.save(order);
		
		sendEmail(savedOrder);
		return savedOrder;
		
	}
	
	
	private void sendEmail(Order savedOrder) {
		
	}
	
	
	
	
	
	
	
	
	

}
