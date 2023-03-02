package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class AdminReviewAction {

    @Id
    @Getter @Setter
    String adminName;

    @Getter @Setter boolean reviewApproved;


    public AdminReviewAction(String adminName, boolean reviewApproved){
        this.adminName = adminName;
        this.reviewApproved = reviewApproved;

    }

}