package com.AshuBoi.app.ws.mobile_app_ws.UserService.Impl;

import com.AshuBoi.app.ws.mobile_app_ws.Model.request.UserDetailsRequestModel;
import com.AshuBoi.app.ws.mobile_app_ws.Model.response.UserRest;
import com.AshuBoi.app.ws.mobile_app_ws.UserService.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest response = new UserRest();
        response.setFirstName(userDetails.getFirstName());
        response.setLastName(userDetails.getLastName());
        response.setEmail(userDetails.getEmail());

        String id = UUID.randomUUID().toString();
        response.setUserId(id);

        if(users ==null) users = new HashMap<>();
        users.put(id, response);
        return response;
    }
}
