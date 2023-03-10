package com.leo.demo.foodapp.foodapi.controller;

import com.leo.demo.foodapp.foodapi.controller.base.BaseApiController;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeRequest;
import com.leo.demo.foodapp.foodapi.models.dto.home.HomeResponse;
import com.leo.demo.foodapp.foodapi.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leo
 * @date 2023/1/17
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseApiController {
    @Autowired
    private IHomeService homeService;

    public HomeController(IHomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public BaseResponse<HomeResponse> hi(@RequestBody HomeRequest request) {
        return this.execService(request, homeService::sayhi);
    }

}
