package com.FoorOrdering.service;

import com.FoorOrdering.model.Category;
import com.FoorOrdering.model.Food;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.request.CreateFoodRequest;

import java.util.List;

public interface FoodServices {
    public Food createFood(CreateFoodRequest reg, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantFood(Long restaurantId,
                                         boolean isVegerarians,
                                         boolean nonvegetarinan,
                                         boolean seasonal,
                                         String foodCategory) throws Exception;

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long id) throws Exception;

    public Food updateAvailabilytiesStatus(Long foodId) throws Exception;

}
