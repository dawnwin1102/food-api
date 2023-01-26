package com.leo.demo.foodapp.foodapi.controllers;

import com.leo.demo.foodapp.foodapi.controllers.base.BaseApiController;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodRequest;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodResponse;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeResponse;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.leo.demo.foodapp.foodapi.service.IFoodFacilityService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author leo
 * @date 2023/1/17
 */
@RestController
@RequestMapping("/food")
public class FoodFacilityController extends BaseApiController {
    private IFoodFacilityService foodFacilityService;

    public FoodFacilityController(IFoodFacilityService foodFacilityService) {
        this.foodFacilityService = foodFacilityService;
    }

    @ApiOperation(value = "get food facility list", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @RequiresAuthentication
    public BaseResponse<Page<FoodFacility>> list(@RequestBody @Validated FoodRequest request) {
        return this.execService(request, foodFacilityService::getFoodFacilitylist);
    }

    @ApiOperation(value = "get food facility detail", httpMethod = "GET")
    @RequestMapping(value = "/detail/{id}", method = {RequestMethod.GET})
    public BaseResponse<FoodFacility> getFoodFacilityDetail(@PathVariable Integer id) {
        return this.execService(id, foodFacilityService::getFoodFacilityDetail);
    }
}
