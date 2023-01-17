package com.leo.demo.foodapp.foodapi;

import com.leo.demo.foodapp.foodapi.dao.FoodRepository;
import com.leo.demo.foodapp.foodapi.models.entities.Food;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class FoodApiApplicationTests {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FoodRepository foodRepository;

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
        log.info(list.toString());
    }
}
