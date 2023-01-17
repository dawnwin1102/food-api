package com.leo.demo.foodapp.foodapi.dao;

import com.leo.demo.foodapp.foodapi.models.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leo
 * @date 2023/1/17
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
