package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.request.SignUpRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
// Cho phép domain khác gọi vào link API
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping ("/signin")
    public ResponseEntity<?> signin(@RequestParam String username,
                                    @RequestParam String password){

        boolean isSuccess = loginService.checkLogin(username,password);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        String message = isSuccess == true ? "Login Successfully" : "Login Failed";
        response.setMessage(message);
        response.setData(isSuccess);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public  ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        boolean isSuccess = loginService.insertUser(signUpRequest);

        BaseResponse response = new BaseResponse();
        String message = isSuccess == true ? "Register Successfully" : "Register Failed";
        response.setMessage(message);
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
