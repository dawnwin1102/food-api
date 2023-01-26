package com.leo.demo.foodapp.foodapi.models.dto.food;

import com.leo.demo.foodapp.foodapi.models.base.BaseRequest;
import com.leo.demo.foodapp.foodapi.models.entities.FoodFacility;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author leo
 * @date 2023/1/17
 */
@Data
public class FoodRequest extends BaseRequest {
    @NotNull
    @Min(value = 0, message = "page should great then 0")
    private Integer page;
    @NotNull
    @Range(min = 10, max = 100, message = "size should be in 10 to 100")
    private Integer size;

    public FoodRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public FoodRequest() {
    }
}
