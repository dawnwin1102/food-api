package com.leo.demo.foodapp.foodapi;

import com.leo.demo.foodapp.foodapi.dao.FoodRepository;
import com.leo.demo.foodapp.foodapi.impl.IFoodFacilityServiceImpl;
import com.leo.demo.foodapp.foodapi.models.entities.Food;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class FoodApiApplicationTests {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IFoodFacilityServiceImpl foodFacilityService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAddRepo() {
        Food food = new Food();
        food.setName("testfood");
        food.setPrice(5);
        Food res = foodRepository.save(food);
        log.info(res.getName());
        List<Food> list = foodRepository.findAll();
        log.info(list.size() + "");
    }

    @Test
    void testSearchRepo() {
        List<Food> list = foodRepository.findAll();
        log.info(list.size() + "");
    }

    @Test
    void testReadCsv() throws CsvException, IOException {
        String pattern = "MM/dd/yyyy hh:mm:ss a";
        String dateStr="03/15/2016 12:00:00 AM";
        LocalDateTime localDateTime=LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        foodFacilityService.initFoodFacilityDB("");


        //2. LocalDateTime
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime.format(DateTimeFormatter.ofPattern(pattern)));

    }
}
