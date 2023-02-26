package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Diner {

    @Id
@Getter @Setter    String displayName;

    @Getter @Setter String city;

    @Getter @Setter String state;

    @Getter @Setter String zipcode;

    @Getter @Setter boolean wantsPeanutAllergyInfo;

    @Getter @Setter boolean wantsEggAllergyInfo;

    @Getter @Setter boolean wantsDairyAllergyInfo;



}
