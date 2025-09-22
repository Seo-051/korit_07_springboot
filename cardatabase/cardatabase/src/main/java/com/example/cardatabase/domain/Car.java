package com.example.cardatabase.domin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand, model, color, registationNuber;

    private int modelYear, price;

    // JPA는 기본 생성자가 필수적으로 요구됨



public Car(String brand, String model, String color, String registationNuber, int modelYear, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registationNuber = registationNuber;
        this.modelYear = modelYear;
        this.price = price;
    }
}
