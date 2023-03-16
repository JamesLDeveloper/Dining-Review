package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.model.Restaurant;
import com.example.RestaurantSpringProject.model.AdminReviewAction;



@Entity
public class AdminReviewAction {

    @Id
    @Getter @Setter
    String adminName;

    @Getter @Setter boolean reviewApproved;

public AdminReviewAction(){}

    public AdminReviewAction(String adminName, boolean reviewApproved){
        this.adminName = adminName;
        this.reviewApproved = reviewApproved;

    }

}