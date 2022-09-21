package fr.polytech.fsback.controllers;

import fr.polytech.fsback.dto.RestaurantDto;
import fr.polytech.fsback.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurantDto(@PathVariable final int id){
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }

    @GetMapping("restaurants")
    public @ResponseBody List<RestaurantDto> getAllRestaurant(){
        return this.restaurantService.getAllRestaurant().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("restaurants")
    public RestaurantDto postRestaurantDto(@Valid @RequestBody RestaurantDto r){
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(r.getNom(), r.getAddress()));
    }
}
