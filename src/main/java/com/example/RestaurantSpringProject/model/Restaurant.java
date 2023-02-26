package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Restaurant {

  @Getter @Setter  private double averagePeanutScore;

    @Getter @Setter  private double averageEggScore;

    @Getter @Setter  private double averageDairyScore;

    @Getter @Setter private double averageOverallScore;

    }