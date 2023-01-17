package com.leo.demo.foodapp.foodapi.impl;

import com.leo.demo.foodapp.foodapi.models.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.HomeResponse;
import com.leo.demo.foodapp.foodapi.service.IHomeService;

/**
 * @author leo
 * @date 2023/1/17
 */
public class IHomeServiceImpl implements IHomeService {
    @Override
    public HomeResponse sayhi(HomeRequest request) {
        HomeResponse homeResponse=new HomeResponse();
        homeResponse.setResult("hello");
        return homeResponse;
    }
}
