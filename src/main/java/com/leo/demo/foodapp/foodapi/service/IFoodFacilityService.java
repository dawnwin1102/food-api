package com.leo.demo.foodapp.foodapi.service;

import com.leo.demo.foodapp.foodapi.models.dto.food.FoodFacilityPageRequest;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodFacilityRequest;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.opencsv.exceptions.CsvException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author leo
 * @date 2023/1/17
 */
public interface IFoodFacilityService {
    List<FoodFacility> initFoodFacilityDB(String fileName) throws IOException, CsvException;

    Page<FoodFacility> getFoodFacilitylist(FoodFacilityPageRequest request);

    Long getFoodFacilityCount();

    FoodFacility getFoodFacilityDetail(Integer id);

    Optional<FoodFacility> getFoodFacilityByLocationId(Integer locationId);

    List<FoodFacility> getFoodFacilityByApplicant(FoodFacilityRequest request);
}
