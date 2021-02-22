package com.test.olafood;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.test.olafood.domain.City;
import com.test.olafood.domain.Meal;
import com.test.olafood.domain.Menu;
import com.test.olafood.domain.Restaurant;
import com.test.olafood.service.OlaFoodService;

@Component
public class SeedData implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired private OlaFoodService foodService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		createSeedData();
	}
	
	private void createSeedData() {
		
		String[] restNames = {"Abc Food restaurant","CDE Meal restaurant",
				"FGH Foods","IJK restaurants","LMN foods","OPQ Restaurants",
				"RST foods and bar","UVW food and bar","XYZ foods and drinks","Abc2 foods","Abc3 foods","Agc foods"}; 
		
		String[] mealNames = {"Rice and beans","Eba and Soup","Yam and Beans","Egusi soup","Egusi and amala"
				,"Yam and plantain","Rice and beans","Eba and Soup","Yam and Beans","Egusi soup","Yam and Beans","Egusi and amala"};
		
		String[] cityNames = {"Abuja","Lagos","Ibadan","Uyo","Port Harcourt","Enugu","Kano","Asaba","Umuahia","Onitsha",
				"Aba","Owerri"};
		
		String[] menusNames = {"Food","Drinks","Desert","Small chops"};
		
		List<Restaurant> restaurants = new ArrayList<>();
		List<Menu> menus = new ArrayList<>();
		for(String name :restNames) {
			restaurants.add(createRestaurant(name));
		}
		
		for(int i=0;i<cityNames.length;i++) {
			//String city = cityNames[i];
			createCity(cityNames[i],restaurants.get(i));
		}
		
		for(String menu: menusNames) {
			
			for(Restaurant rest:restaurants) {
				Menu mn =createMenu(menu,"This is a sample menu",rest);
				if(mn.getTitle().equalsIgnoreCase("Food"))
					menus.add(mn);
			}
			
		}
		
		for(String meal : mealNames) {
			for(Menu menu : menus) {
				createMeal(meal,500.0,menu);
			}
		}
		
		
		
	}
	
	private Restaurant createRestaurant(String name) {
		Restaurant rest = new Restaurant();
		rest.setEmail("abc@gmail.com");
		rest.setName(name);
		rest.setPhone("08077723563");
		//rest.setLogoUrl("url);
		return foodService.createOrUpdateRestaurant(rest);
	}
	
	private void createCity(String cityName,Restaurant rest) {
		
		City city = new City();
		city.setCityName(cityName);
		city.setRestaurant(rest);
		foodService.createCity(city);
		
	}
	
	private Menu createMenu(String title,String description,Restaurant rest) {
		
		Menu menu = new Menu();
		menu.setTitle(title);
		menu.setDescription(description);
		menu.setRestaurant(rest);
		return foodService.createMenu(menu);
		
	}
	
	private void createMeal(String name,double price,Menu menu) {
		
		Meal meal = new Meal();
		meal.setDescription("This is a sample description of the meal, it tastes sooo delicious");
		meal.setMenu(menu);
		meal.setName(name);
		meal.setPrice(price);
		meal.setTimeToPepare("15 mins");
		meal.setPictureUrl("https://media-cdn.tripadvisor.com/media/photo-s/1a/2a/94/bc/saviour-african-food.jpg");
		foodService.createMeal(meal);
	}

	
	
	
	
	
	
	
	
	
	
	
}
