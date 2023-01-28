package com.leo.demo.foodapp.foodapi.models.dto.food;

import com.leo.demo.foodapp.foodapi.models.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author leo
 * @date 2023/1/17
 */
@Data
public class FoodFacilityRequest extends BaseRequest {
    @ApiModelProperty(value = "applicant name")
    @NotNull
    private String applicant;
}
