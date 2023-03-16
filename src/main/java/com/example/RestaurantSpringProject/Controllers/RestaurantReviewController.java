package com.example.RestaurantSpringProject.Controllers;

import com.example.RestaurantSpringProject.repositories.DiningReviewRepository;
import com.example.RestaurantSpringProject.repositories.DinerRepository;
import com.example.RestaurantSpringProject.repositories.RestaurantRepository;
import com.example.RestaurantSpringProject.repositories.ReviewStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import com.example.RestaurantSpringProject.model.*;
//import org.apache.commons.text.WordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/restaurants")
public class RestaurantReviewController {

    private final DiningReviewRepository diningReviewRepository;
    private final DinerRepository dinerRepository;
    private final RestaurantRepository restaurantRepository;

//    private final ReviewStatus reviewStatus;

    public RestaurantReviewController(final DiningReviewRepository diningReviewRepository, DinerRepository dinerRepository, RestaurantRepository restaurantRepository/*, ReviewStatus reviewStatus*/) {
        this.diningReviewRepository = diningReviewRepository;
        this.dinerRepository = dinerRepository;
        this.restaurantRepository = restaurantRepository;
//        this.reviewStatus = reviewStatus;
    }

    @PostMapping("/diner")
    public Diner addNewDiner(@RequestBody Diner diner) {

        Optional<Diner> addNewDinerOptional = this.dinerRepository.getByDisplayName(diner.getDisplayName());

        if (addNewDinerOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        Diner newDiner = this.dinerRepository.save(diner);

        return newDiner;
    }


    @PutMapping("/diner/{displayName}")

    public Diner updateDinerProfileByDisplayName(@RequestParam String displayName, @RequestParam String city, @RequestParam String state, @RequestParam String zipcode, @RequestParam boolean wantsPeanutAllergyInfo, @RequestParam boolean wantsEggAllergyInfo, @RequestParam boolean wantsDairyAllergyInfo) {
        Optional<Diner> displayNameOptional = this.dinerRepository.getByDisplayName(displayName);

        if (displayNameOptional.isEmpty()) {
            //HttpStatusCode
            return null;
        }

        Diner dinerToUpdate = displayNameOptional.get();

        if (!city.isEmpty()) {
            dinerToUpdate.setCity(city);
        }
        if (!state.isEmpty()) {
            dinerToUpdate.setState(state);
        }
        if (!zipcode.isEmpty()) {
            dinerToUpdate.setZipcode(zipcode);
        }
//if (wantsDairyAllergyInfo != null) {
//    diner.setWantsEggAllergyInfo(wantsEggAllergyInfo);
//}

        if (wantsDairyAllergyInfo == true) {
            dinerToUpdate.setWantsEggAllergyInfo(true);
        } else if (wantsDairyAllergyInfo == false) {
            dinerToUpdate.setWantsDairyAllergyInfo(false);
        }

//if(wantsEggAllergyInfo != null) {
//    diner.setWantsEggAllergyInfo(wantsEggAllergyInfo);
//}

        if (wantsEggAllergyInfo == true) {
            dinerToUpdate.setWantsEggAllergyInfo(true);
        } else if (wantsEggAllergyInfo == false) {
            dinerToUpdate.setWantsEggAllergyInfo(false);
        }
//if (wantsPeanutAllergyInfo != null) {
//        diner.setWantsPeanutAllergyInfo(wantsPeanutAllergyInfo);
//    }

        if (wantsPeanutAllergyInfo == true) {
            dinerToUpdate.setWantsPeanutAllergyInfo(true);
        } else if (wantsPeanutAllergyInfo == false) {
            dinerToUpdate.setWantsPeanutAllergyInfo(false);
        }

        Diner updatedDiner = this.dinerRepository.save(dinerToUpdate);

        return updatedDiner;
    }

    @GetMapping("/diner/{displayName}")
    public Diner findByDisplayName(@PathVariable("displayName") String displayName) {
        Optional<Diner> findDinerByDisplayNameOptional = this.dinerRepository.getByDisplayName(displayName);

        if (!findDinerByDisplayNameOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        Diner dinerFoundByDisplayName = findDinerByDisplayNameOptional.get();

        return dinerFoundByDisplayName;
    }

    @GetMapping("/diner/checkReview/{displayName}")
    public boolean isRealUser(@RequestParam String reviewerName, @PathVariable String displayName) {
        if (reviewerName.equals(displayName)) {
            return true;
        } else {
            return false;
        }
    }


    @PostMapping("/diningReview/postReview")
    public DiningReview submitReview(@RequestBody DiningReview diningReview) {
        Optional<DiningReview> newReviewOptional = this.diningReviewRepository.getByReviewerName(diningReview.getReviewerName());
        if (newReviewOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        diningReview.setReviewStatus(ReviewStatus.PENDING);
        DiningReview newReview = this.diningReviewRepository.save(diningReview);
        return newReview;
    }


    @GetMapping("/diningReview/pendingReviews")
    public List<DiningReview> getPendingReviewsList (@RequestParam ReviewStatus reviewStatus) {

        List<DiningReview> pendingReviewsList = this.diningReviewRepository.getAllByReviewStatus(reviewStatus);

        return pendingReviewsList;
    }

@PutMapping("/diningReview/{id}")
public DiningReview updateReviewStatus (@RequestParam ReviewStatus reviewStatus, @PathVariable("id") Long id) {

        Optional<DiningReview> getReviewToUpdateOptional = this.diningReviewRepository.findById(id);

        if (!getReviewToUpdateOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        DiningReview reviewToUpdate = getReviewToUpdateOptional.get();

reviewToUpdate.setReviewStatus(ReviewStatus.APPROVED);
        DiningReview updatedReview = this.diningReviewRepository.save(reviewToUpdate);
return  updatedReview;
}

@GetMapping("/diningReview/{restuarantName}")
           public List<Restaurant> chosenRestaurantReviews (@PathVariable ("restaurantName") String chosenRestaurantName){
    List<Restaurant> chosenRestaurantReviewList = this.restaurantRepository.getAllByRestaurantName(chosenRestaurantName);

    return chosenRestaurantReviewList;
    }

@PostMapping("/restaurant")
public Restaurant addNewRestaurant (@RequestBody Restaurant restaurant){

        Optional<Restaurant> getRestaurantToCheckOptional = this.restaurantRepository.getByRestaurantNameAndZipcode(restaurant.getRestaurantName(), restaurant.getZipcode());

        if (getRestaurantToCheckOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

//        Restaurant newRestaurantToAdd = getRestaurantToCheckOptional.get();

        Restaurant addedRestaurant = this.restaurantRepository.save(restaurant);

        return addedRestaurant;

}

@GetMapping("/restaurant/{id}")
    public Restaurant fetchRestaurantDetails (@PathVariable ("id") Long id){
        Optional<Restaurant> getRestaurantDetailsOptional = this.restaurantRepository.getById(id);

        if (!getRestaurantDetailsOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Restaurant restaurantDetails = getRestaurantDetailsOptional.get();

        return restaurantDetails;
}

@GetMapping("restaurant/{zipcode}")
public List<Restaurant> getRestaurantsInZipcodeWithAllergyReview(@PathVariable ("zipcode") String zipcode, @RequestParam ("allergy") boolean wantsEggAlleryInfo, @RequestParam ("allergy") boolean wantsDairyAlleryInfo, @RequestParam ("allergy") boolean wantsPeanutAlleryInfo)
    {
        if (wantsEggAlleryInfo) {
            List<Restaurant> restaurantsInZipcodeWithAllergyReview = this.restaurantRepository.getByZipcodeOrderByAverageEggScoreDesc(zipcode);
            List<Restaurant> restaurantsWithEggReviews = new ArrayList<>();
            for (Restaurant restaurant: restaurantsInZipcodeWithAllergyReview){
                                if (restaurant.getAverageEggScore() > 0){
                    restaurantsWithEggReviews.add(restaurant);
                }
            }
            return restaurantsWithEggReviews;

        } else if (wantsDairyAlleryInfo){
            List<Restaurant> restaurantsInZipcodeWithAllergyReview = this.restaurantRepository.getByZipcodeOrderByAverageDairyScoreDesc(zipcode);
            List<Restaurant> restaurantsWithDairyReviews = new ArrayList<>();
            for (Restaurant restaurant: restaurantsInZipcodeWithAllergyReview){
                if (restaurant.getAverageDairyScore() > 0){
                    restaurantsWithDairyReviews.add(restaurant);
                }
            }
            return restaurantsWithDairyReviews;

        } else if (wantsPeanutAlleryInfo) {
            List<Restaurant> restaurantsInZipcodeWithAllergyReview = this.restaurantRepository.getByZipcodeOrderByAveragePeanutScoreDesc(zipcode);
            List<Restaurant> restaurantsWithPeanutReviews = new ArrayList<>();
            for (Restaurant restaurant: restaurantsInZipcodeWithAllergyReview){
                if (restaurant.getAveragePeanutScore() > 0){
                    restaurantsWithPeanutReviews.add(restaurant);
                }
            }
            return restaurantsWithPeanutReviews;

        } else {
            List<Restaurant> restaurantsInZipCode = this.restaurantRepository.getByZipcode(zipcode);
            return  restaurantsInZipCode;
    }

   //     else return List
    }

}

