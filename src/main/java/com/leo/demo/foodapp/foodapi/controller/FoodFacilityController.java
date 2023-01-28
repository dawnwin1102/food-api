package com.leo.demo.foodapp.foodapi.controller;

import com.leo.demo.foodapp.foodapi.controller.base.BaseApiController;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodFacilityPageRequest;
import com.leo.demo.foodapp.foodapi.models.dto.food.FoodFacilityRequest;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import com.leo.demo.foodapp.foodapi.service.IFoodFacilityService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

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
    @Cacheable("food_facility")
    public BaseResponse<Page<FoodFacility>> list(@RequestBody @Validated FoodFacilityPageRequest request) {
        return this.execService(request, foodFacilityService::getFoodFacilitylist);
    }


    @ApiOperation(value = "get food facility list need authentication", httpMethod = "POST")
    @RequestMapping(value = "/auth/list", method = {RequestMethod.POST})
    @RequiresAuthentication
    @Cacheable("auth_food_facility")
    public BaseResponse<Page<FoodFacility>> authlist(@RequestBody @Validated FoodFacilityPageRequest request) {
        return this.execService(request, foodFacilityService::getFoodFacilitylist);
    }

    @ApiOperation(value = "get food facility list by applicant", httpMethod = "POST")
    @RequestMapping(value = "/listbyapplicant", method = {RequestMethod.POST})
    @Cacheable("food_facility")
    public BaseResponse<List<FoodFacility>> listByApplicant(@RequestBody @Validated FoodFacilityRequest request) {
        return this.execService(request, foodFacilityService::getFoodFacilityByApplicant);
    }

    @ApiOperation(value = "get food facility detail", httpMethod = "GET")
    @RequestMapping(value = "/detail/{id}", method = {RequestMethod.GET})
    @Cacheable("food_facility")
    public BaseResponse<FoodFacility> getFoodFacilityDetail(@PathVariable @NotNull Integer id) {
        return this.execService(id, foodFacilityService::getFoodFacilityDetail);
    }
}
