package com.leo.demo.foodapp.foodapi.controller;

import com.leo.demo.foodapp.foodapi.dummydatabase.UserBean;
import com.leo.demo.foodapp.foodapi.impl.UserService;
import com.leo.demo.foodapp.foodapi.exception.UnauthorizedException;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.base.ResponseCode;
import com.leo.demo.foodapp.foodapi.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public BaseResponse login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        UserBean userBean = userService.getUser(username);
        if (userBean.getPassword().equals(password)) {
            BaseResponse response = new BaseResponse(ResponseCode.Code_0000);
            response.setResult(JWTUtil.sign(username, password));
            return response;
        } else {
            throw new UnauthorizedException();
        }
    }
}
