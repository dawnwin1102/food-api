package com.leo.demo.foodapp.foodapi.impl;

import com.leo.demo.foodapp.foodapi.dao.FoodFacilityRepository;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodRequest;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.leo.demo.foodapp.foodapi.service.IFoodFacilityService;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class IFoodFacilityServiceImpl implements IFoodFacilityService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FoodFacilityRepository foodFacilityRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<FoodFacility> initFoodFacilityDB(String fileName) throws IOException, CsvException {
        if (StringUtils.isBlank(fileName) || Files.notExists(Paths.get(fileName))) {
            // set to default file
            fileName = "Mobile_Food_Facility_Permit.csv";
        }
        // clean
        List<FoodFacility> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(FoodFacility.class).build().parse();
        return foodFacilityRepository.saveAllAndFlush(beans);
    }

    @Override
    public Page<FoodFacility> getFoodFacilitylist(FoodRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return foodFacilityRepository.findAll(pageable);
    }

    @Override
    public Long getFoodFacilityCount() {
        return foodFacilityRepository.count();
    }

    @Override
    public FoodFacility getFoodFacilityDetail(Integer id) {
        FoodFacility res = foodFacilityRepository.findById(id).get();
        return res;
    }

    public Optional<FoodFacility> getFoodFacilityByLocationId(Integer locationId) {
        return foodFacilityRepository.findByLocationId(locationId);
    }

    public List<FoodFacility> getFoodFacilityByApplicant(String applicant) {
        return foodFacilityRepository.findAllByApplicant(applicant);
    }
}
