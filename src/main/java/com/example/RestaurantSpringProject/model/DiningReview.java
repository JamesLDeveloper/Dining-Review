package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

@Entity
public class DiningReview {

    @Id
    @GeneratedValue
    @Getter @Setter    private Long id;

    @Getter @Setter    private String reviewerName;

    @Getter @Setter   private int peanutScore;

    @Getter @Setter    private int eggScore;

    @Getter @Setter   private int dairyScore;

    @Getter @Setter    private String userComments;

    public DiningReview (){
    }





}
