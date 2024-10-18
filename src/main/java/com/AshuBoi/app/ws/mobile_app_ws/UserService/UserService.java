package com.AshuBoi.app.ws.mobile_app_ws.UserService;


import com.AshuBoi.app.ws.mobile_app_ws.Model.request.UserDetailsRequestModel;
import com.AshuBoi.app.ws.mobile_app_ws.Model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userRest);
}
