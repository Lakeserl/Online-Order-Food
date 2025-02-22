package com.FoorOrdering.service;

import com.FoorOrdering.model.Category;
import com.FoorOrdering.model.Food;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.repository.FoodRepository;
import com.FoorOrdering.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImplement implements FoodServices{

    @Autowired
    private FoodRepository foodRepository;


    @Override
    public Food createFood(CreateFoodRequest reg, Category category, Restaurant restaurant) {
        Food food = new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(reg.getDescription());
        food.setName(reg.getName());
        food.setImages(reg.getImages());
        food.setPrice(reg.getPrice());
        food.setIngredients(reg.getIngredients());
        food.setSeasonal(reg.isSeasonal());
        food.setVegetarian(reg.isVegetarian());

        Food savedFood = foodRepository.save(food);
        restaurant.getFoods().add(savedFood);

        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {

        Food food = findFoodById(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);

    }

    public Food findFoodById(Long foodId) throws Exception {
        Optional<Food> food = foodRepository.findById(foodId);

        if(food.isEmpty()){
            throw new Exception("Food not found Or Exist" + foodId);
        }
        return food.get();
    }

    @Override
    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegerarians,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory) throws Exception {
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);

        if(isVegerarians) {
            foods = filterByVegetarian(foods, isVegerarians);
        }
        if(isNonveg) {
            foods=filterByNonveg(foods, isNonveg);
        }
        if(isSeasonal) {
            foods = filterBySeasonal(foods, isSeasonal);
        }
        if(foodCategory != null && !foodCategory.isEmpty()) {
            foods= filterByCategory(foods, foodCategory);
        }

        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory() != null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonal()==isSeasonal).collect(Collectors.toList());

    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg) {
        return foods.stream().filter(food -> food.isVegetarian()==false).collect(Collectors.toList());

    }

    private List<Food> filterByVegetarian(List<Food> foods, boolean isVegerarians) {
        return foods.stream().filter(food -> food.isVegetarian()==isVegerarians).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }


    @Override
    public Food updateAvailabilytiesStatus(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setAvailable(!food.isAvailable());
        return null;
    }
}
