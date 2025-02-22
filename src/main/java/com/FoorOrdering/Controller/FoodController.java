package com.FoorOrdering.Controller;

import com.FoorOrdering.model.Food;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.model.User;
import com.FoorOrdering.request.CreateFoodRequest;
import com.FoorOrdering.service.FoodServices;
import com.FoorOrdering.service.RestaurantService;
import com.FoorOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodServices foodServices;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping("/search ")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Food> food = foodServices.searchFood(name);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    };

    @PostMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegetarinan,
                                                        @RequestParam boolean seasonal,
                                                        @RequestParam boolean nonvegetarinan,
                                                        @RequestParam (required = false) String food_category,
                                                        @PathVariable long restaurantId,
                                                        @RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Food> food = foodServices.getRestaurantFood(restaurantId,vegetarinan,nonvegetarinan,seasonal,food_category);

        return new ResponseEntity<>(food, HttpStatus.OK);
    };
}
