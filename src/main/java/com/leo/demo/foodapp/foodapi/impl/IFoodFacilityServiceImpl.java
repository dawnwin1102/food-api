package com.leo.demo.foodapp.foodapi.impl;

import com.leo.demo.foodapp.foodapi.dao.FoodFacilityRepository;
import com.leo.demo.foodapp.foodapi.dao.FoodRepository;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class IFoodFacilityServiceImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FoodFacilityRepository foodFacilityRepository;
    @Autowired
    private EntityManager entityManager;

    public void initFoodFacilityDB(String fileName) throws IOException, CsvException {
//        List<String[]> values = new CSVReaderHeaderAware(new FileReader("Mobile_Food_Facility_Permit.csv")).readAll();
        if (StringUtils.isBlank(fileName) || Files.notExists(Paths.get(fileName))) {
            // set to default file
            fileName = "Mobile_Food_Facility_Permit.csv";
        }
        // clean
        List<FoodFacility> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(FoodFacility.class).build().parse();
        List<FoodFacility> res = foodFacilityRepository.saveAll(beans);
//        logger.info(res.size() + "");
    }
}
