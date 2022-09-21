package fr.polytech.fsback.service;

import com.sun.tools.javac.main.Option;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.exception.IdDoesntExistException;
import fr.polytech.fsback.exception.InvalidValueException;
import fr.polytech.fsback.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantById(int id){
        return this.restaurantRepository.findById(id)
                .orElseThrow(() -> new IdDoesntExistException("restaurant with id " + id + "doesn't exist."));
    }

    public List<RestaurantEntity> getAllRestaurant() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity addRestaurant(final String nom, final String address){
        final RestaurantEntity restaurantEntity = RestaurantEntity.builder().nom(nom).address(address).build();
        return this.restaurantRepository.save(restaurantEntity);
    }

    public RestaurantEntity updateRestaurant(int id, String nom, String address){
        if (nom == null || address == null){
            throw new InvalidValueException("Le nom ou l'adresse du restaurant ne peuvent être vides.");
        }
        final RestaurantEntity restaurantEntity = this.restaurantRepository.findById(id)
                .orElseThrow(() -> new IdDoesntExistException("La bibliothèque d'id " + id + " n'existe pas."));
        restaurantEntity.setNom(nom);
        restaurantEntity.setAddress(address);
        restaurantRepository.save(restaurantEntity);
        return restaurantEntity;
    }
}
