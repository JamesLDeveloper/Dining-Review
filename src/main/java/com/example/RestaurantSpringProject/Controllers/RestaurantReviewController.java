package com.example.RestaurantSpringProject.Controllers;

import com.example.RestaurantSpringProject.repositories.DiningReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import com.example.RestaurantSpringProject.model.*;
//import org.apache.commons.text.WordUtils;
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


@RestController
@RequestMapping("/restaurants")
public class RestaurantReviewController {

private final DiningReviewRepository diningReviewRepository;


    public RestaurantReviewController(final DiningReviewRepository diningReviewRepository){
        this.diningReviewRepository = diningReviewRepository;
}




}
