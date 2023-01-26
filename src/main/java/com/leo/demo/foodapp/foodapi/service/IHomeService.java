package com.leo.demo.foodapp.foodapi.service;

import com.leo.demo.foodapp.foodapi.models.dto.home.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeResponse;

/**
 * @author leo
 * @date 2023/1/17
 */
public interface IHomeService {
    HomeResponse sayhi(HomeRequest request);
}
