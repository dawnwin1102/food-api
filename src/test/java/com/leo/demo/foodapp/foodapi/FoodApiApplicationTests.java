package com.leo.demo.foodapp.foodapi;

import com.leo.demo.foodapp.foodapi.impl.IFoodFacilityServiceImpl;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodFacilityRequest;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.leo.demo.foodapp.foodapi.util.JWTUtil;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class FoodApiApplicationTests {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IFoodFacilityServiceImpl foodFacilityService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetFoodFacilityByLocationIdReturnSuccess() {
        Optional<FoodFacility> foodFacility = foodFacilityService.getFoodFacilityByLocationId(1568947);
        Assertions.assertEquals("Senor Sisig", foodFacility.get().getApplicant());
    }

    @Test
    void testGetFoodFacilityByApplicantReturnSuccess() {
        FoodFacilityRequest request = new FoodFacilityRequest();
        request.setApplicant("Senor Sisig");
        List<FoodFacility> foodFacilityList = foodFacilityService.getFoodFacilityByApplicant(request);
        Assertions.assertEquals(8, foodFacilityList.size());
    }

    @Test
    void testGetFoodFacilityDetailReturnSuccess() {
        FoodFacility foodFacility = foodFacilityService.getFoodFacilityDetail(1);
        Assertions.assertNotNull(foodFacility);
    }

    @Test
    void testGetFoodFacilityByApplicantEmpty() {
        FoodFacilityRequest request = new FoodFacilityRequest();
        request.setApplicant("xxxxxxxxxx");
        List<FoodFacility> foodFacilityList = foodFacilityService.getFoodFacilityByApplicant(request);
        Assertions.assertTrue(foodFacilityList.isEmpty());
    }

    @Test
    void testGetFoodFacilityByApplicantThrowExceptioon() {
        Assertions.assertThrows(Exception.class, () -> {
            foodFacilityService.getFoodFacilityByApplicant(null);
        });
    }

    @Test
    void testJWTUtilgetUsernameFromValidToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzUwMjc2MTQsInVzZXJuYW1lIjoibGVvIn0.JcgERv_AjgCF0M1hi6oYLPPABIGjbP4KEHnsnYpcgE8";
        String userName = JWTUtil.getUsername(token);
        Assertions.assertEquals("leo",userName);
    }

    @Test
    void testJWTUtilgetUsernameFromWrongToken() {
        String token = "xxxeyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzUwMjc2MTQsInVzZXJuYW1lIjoibGVvIn0.JcgERv_AjgCF0M1hi6oYLPPABIGjbP4KEHnsnYpcgE8";
        String userName = JWTUtil.getUsername(token);
        Assertions.assertNull(userName);
    }
}
