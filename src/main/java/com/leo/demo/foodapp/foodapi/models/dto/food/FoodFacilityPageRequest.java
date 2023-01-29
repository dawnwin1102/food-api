package com.leo.demo.foodapp.foodapi.models.dto.food;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;

/**
 * @author leo
 * @date 2023/1/17
 */
public class FoodFacilityPageRequest extends PageableRequest {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
