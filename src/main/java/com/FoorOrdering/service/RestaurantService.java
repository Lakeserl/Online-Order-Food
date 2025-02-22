package com.FoorOrdering.service;

import com.FoorOrdering.DTO.RestaurantDTO;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.model.User;
import com.FoorOrdering.request.CreateRestaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRestaurant reg, User user);

    public Restaurant updateRestaurant(Long id, CreateRestaurant updateRestaurant) throws Exception;

    public void deleteRestaurant(Long id) throws Exception;

    public List<Restaurant> getAllRestaurants();

    public List<Restaurant> searchRestaurant(String key);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantById(Long id) throws Exception;

    public RestaurantDTO addToFavourites(Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;

}
