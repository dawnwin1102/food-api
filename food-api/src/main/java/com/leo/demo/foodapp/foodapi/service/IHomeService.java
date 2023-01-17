package com.leo.demo.foodapp.foodapi.service;

import com.leo.demo.foodapp.foodapi.models.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.HomeResponse;

/**
 * @author leo
 * @date 2023/1/17
 */
public interface IHomeService {
    HomeResponse sayhi(HomeRequest request);
}
