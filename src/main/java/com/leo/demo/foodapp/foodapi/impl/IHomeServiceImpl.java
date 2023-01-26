package com.leo.demo.foodapp.foodapi.impl;

import com.leo.demo.foodapp.foodapi.models.dto.home.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeResponse;
import com.leo.demo.foodapp.foodapi.service.IHomeService;
import org.springframework.stereotype.Service;

/**
 * @author leo
 * @date 2023/1/17
 */
@Service
public class IHomeServiceImpl implements IHomeService {
    @Override
    public HomeResponse sayhi(HomeRequest request) {
        HomeResponse homeResponse=new HomeResponse();
        homeResponse.setResult("hello");
        return homeResponse;
    }
}
