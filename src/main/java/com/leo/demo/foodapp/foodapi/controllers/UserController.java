package com.leo.demo.foodapp.foodapi.controllers;

import com.leo.demo.foodapp.foodapi.dummydatabase.UserBean;
import com.leo.demo.foodapp.foodapi.dummydatabase.UserService;
import com.leo.demo.foodapp.foodapi.exception.UnauthorizedException;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.base.ResponseCode;
import com.leo.demo.foodapp.foodapi.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/init")
//    public String init(){
//        User user = null;
//        for(int i=0;i<10;i++){
//            user = new User();
//            user.setName("test"+i);
//            userService.save(user);
//        }
//        return "初始化完成。";
//    }

//    @GetMapping("/userByName/{username}")
//    public User getUserByName(@PathVariable("username") String username){
//        return userService.getByName(username);
//    }
//
//    @GetMapping("/userById/{userid}")
//    public User getUserById(@PathVariable("userid") Long userid){
//        return userService.getUserByID(userid);
//    }
//
//    @GetMapping("/page")
//    public Page<User> getPage(){
//        return userService.findPage();
//    }
//
//    @GetMapping("/page/{maxID}")
//    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID){
//        return userService.find(maxID);
//    }
//
//    @RequestMapping("/update/{id}/{name}")
//    public User update(@PathVariable Long id, @PathVariable String name){
//        return userService.update(id,name);
//    }
//
//    @RequestMapping("/update/{id}")
//    public Boolean updateById(@PathVariable Long id){
//        return userService.updateById("newName",id);
//    }

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
