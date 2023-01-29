package com.leo.demo.foodapp.foodapi.impl;

import com.leo.demo.foodapp.foodapi.dummydatabase.DataSource;
import com.leo.demo.foodapp.foodapi.dummydatabase.UserBean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserService {

    public UserBean getUser(String username) {
        if (!DataSource.getData().containsKey(username)) {
            return null;
        }

        UserBean user = new UserBean();
        Map<String, String> detail = DataSource.getData().get(username);

        user.setUsername(username);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }
}
