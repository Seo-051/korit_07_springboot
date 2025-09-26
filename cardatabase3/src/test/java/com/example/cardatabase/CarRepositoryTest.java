package com.example.cardatabase;


import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("차량 저장 메서드 테스트")
    void saveCar() {
        // given - 제반 준비 사항
        // Car Entity를 확인해봤을때 field로 Owner를 요구하기 때문에
        // 얘부터 먼저 만들고 -> ownerRepossitory에 저장

        Owner owner = new Owner("Gemini", "GPT");
        ownerRepository.save(owner);
        // 그리고 Car 객체를 만들겁니다.
        Car car = new Car("Ford", "Mustang", "Red", "ABCEDF", 2021, 567890, owner);

        // when - 테스트 실행
        // 저장이 됐는가를 확인하기 위한 부분
        carRepository.save(car);
        // then - 그 결과가 어떠할지
        assertThat(carRepository.findById(car.getId())).isPresent(); // 이거는 그냥 결과값이 하나일테니까.

        assertThat(carRepository.findById(car.getId()).get().getBrand()).isEqualTo("Ford");
    }

    @Test
    @DisplayName("삭제 테스트 : ")
    void deleteCars() {
        Owner owner1 = new Owner("이", "이");
        ownerRepository.save(owner1);
        Car car = new Car("Ford", "Mustang", "Red", "ABCEDF", 2021, 567890, owner1);
        carRepository.save(car);

        carRepository.deleteById(car.getId());

        assertThat(carRepository.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("테스트 : ")
    void findByBrandShouldReturnCar(){
        Owner owner1 = new Owner("이", "이");
        ownerRepository.save(owner1);
        Car car = new Car("Ford", "Mustang", "Red", "ABCEDF", 2021, 567890, owner1);
        Car car1 = new Car("Hyendai", "Mustang", "Red", "ABCEDF", 2021, 567890, owner1);
        Car car2 = new Car("Hyendai", "Mustang", "Red", "ABCEDF", 2021, 567890, owner1);
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> hyendais = carRepository.findByBrand("Hyendai");

        assertThat(hyendais.get(0).getBrand()).isEqualTo("hyendai");

        assertThat(hyendais.size()).isEqualTo(2);
    }


}
