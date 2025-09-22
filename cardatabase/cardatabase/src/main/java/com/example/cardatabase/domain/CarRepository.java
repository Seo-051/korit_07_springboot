package com.example.cardatabase.domin;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    // 브랜드로 자동차를 검색
    List<Car> findByBrand(String brand);

    // 브랜드와 모델을 합쳐서 자동차를 검색
    List<Car> findByBrandAndModel(String brand, String model);

    // 브랜드

    List<Car> findByColor(String white);
    List<Car> findByModelYear(int modelYear);
}
