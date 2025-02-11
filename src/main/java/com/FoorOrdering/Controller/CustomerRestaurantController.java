package com.FoorOrdering.Controller;

import com.FoorOrdering.DTO.RestaurantDTO;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.model.User;
import com.FoorOrdering.service.RestaurantService;
import com.FoorOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurants")
public class CustomerRestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String key
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.searchRestaurant(key);
            return new ResponseEntity<>(restaurant, HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK );
    }

    @GetMapping("/{id")
    public ResponseEntity<Restaurant> findRestaurantsbyId(
            @RequestHeader("Authorization") String jwt,
             @PathVariable Long id

    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK );
    }

    @PutMapping("/{id}/add-your-favourite")
    public ResponseEntity<RestaurantDTO> addToYourFavourite(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        RestaurantDTO restaurant = restaurantService.addToFavourites(id, user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
