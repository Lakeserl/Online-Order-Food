package com.FoorOrdering.service;

import com.FoorOrdering.DTO.RestaurantDTO;
import com.FoorOrdering.model.Address;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.model.User;
import com.FoorOrdering.repository.AddressRepository;
import com.FoorOrdering.repository.RestaurantRepository;
import com.FoorOrdering.repository.UserRespository;
import com.FoorOrdering.request.CreateRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImplement implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRespository userRespository;


    @Override
    public Restaurant createRestaurant(CreateRestaurant reg, User user) {
        Address address = addressRepository.save(reg.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContractInfor(reg.getContractInfor());
        restaurant.setCuisineType(reg.getCuisineType());
        restaurant.setDescription(reg.getDescription());
        restaurant.setImages(reg.getImages());
        restaurant.setName(reg.getName());
        restaurant.setOpeningHours(reg.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, CreateRestaurant updateRestaurant) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        if(restaurant.getCuisineType() != null ){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }

        if(restaurant.getDescription() != null ){
            restaurant.setDescription(updateRestaurant.getDescription());
        }

        if(restaurant.getName() != null ){
            restaurant.setName(updateRestaurant.getName());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String key) {
        return restaurantRepository.findBySearchQuery(key);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant> opt = restaurantRepository.findById(id);

        if(opt.isEmpty()) {
            throw new Exception("Restaurant not found" + id);
        }

        return opt.get();
    }

    @Override
    public Restaurant getRestaurantById(Long userId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);
        if(restaurant == null) {
            throw new Exception("Restaurant not found" + userId);
        }

        return restaurant;
    }

    @Override
    public RestaurantDTO addToFavourites(Long restaurantId, User user) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        RestaurantDTO dto = new RestaurantDTO();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantId);

        if(user.getFavourite().contains(dto)){
            user.getFavourite().remove(dto);
        }
        else user.getFavourite().add(dto);

        userRespository.save(user);
        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
