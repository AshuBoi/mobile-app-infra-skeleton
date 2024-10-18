package com.AshuBoi.app.ws.mobile_app_ws.ui;


import Exceptions.UserServiceException;
import com.AshuBoi.app.ws.mobile_app_ws.Model.request.UpdateUserDetailsRequestModel;
import com.AshuBoi.app.ws.mobile_app_ws.Model.request.UserDetailsRequestModel;
import com.AshuBoi.app.ws.mobile_app_ws.Model.response.UserRest;
import com.AshuBoi.app.ws.mobile_app_ws.UserService.Impl.UserServiceImpl;
import com.AshuBoi.app.ws.mobile_app_ws.UserService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http/localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

//    @GetMapping
//    public String getUser(@RequestParam(value="page", defaultValue="1") int page,
//                          @RequestParam(value="limit", defaultValue="50") int limit)
//    {
//        return "get users was called with page = " + page + " and limit = " + limit ;
//    }

    @GetMapping
    public String getUser(@RequestParam(value="page", defaultValue="1") int page,
                          @RequestParam(value="limit", defaultValue="50") int limit,
                          @RequestParam(value="sort",defaultValue = "desc", required = false) String sort)
                            // required param does not work well with primitives because they cant generate null
                            // value without initializing so use wrapper classes
    {
        // if (sort == null) { sort ="desc"; }
        return "get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort ;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//        UserRest response = new UserRest();
//        response.setUserId(userId);
//        response.setFirstName("AshuBoi");
//        response.setLastName("TrAsh");
//        response.setEmail("ashuboi@gmail.com");
        if (true) throw new UserServiceException("A user service exception is thrown");
        return null;
    }

    @PostMapping(
            consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                        })


    public UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue =  userService.createUser(userDetails);

        return new ResponseEntity<>(returnValue, HttpStatus.OK).getBody();
    }


    @PutMapping(path = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
    {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId)
    {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
