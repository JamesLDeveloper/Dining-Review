package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
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

public Diner (String displayName, String city, String state, String zipcode, boolean wantsPeanutAllergyInfo, boolean wantsEggAllergyInfo, boolean wantsDairyAllergyInfo){
    this.displayName = displayName;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.wantsPeanutAllergyInfo = wantsPeanutAllergyInfo;
    this.wantsEggAllergyInfo = wantsEggAllergyInfo;
    this.wantsDairyAllergyInfo = wantsDairyAllergyInfo;
}

}
