package com.leo.demo.foodapp.foodapi.dao;

import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author leo
 * @date 2023/1/17
 */
@Repository
public interface FoodFacilityRepository extends JpaRepository<FoodFacility, Integer> {
    Optional<FoodFacility> findByLocationId(Integer locationId);

    List<FoodFacility> findAllByApplicant(String applicant);
}
