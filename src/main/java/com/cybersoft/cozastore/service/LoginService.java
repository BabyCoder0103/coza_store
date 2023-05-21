package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.payload.request.SignUpRequest;
import com.cybersoft.cozastore.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepositoty userRepositoty;

    public boolean checkLogin(String username, String password){
        List<UserEntity> list = userRepositoty.findByUsernameAndPassword(username,password);
        return list.size() > 0;
    }

    public boolean insertUser(SignUpRequest signUpRequest){
        try{
            UserEntity user = new UserEntity();
            user.setEmail(signUpRequest.getEmail());
            user.setUsername(signUpRequest.getUsername());
            user.setPassword(signUpRequest.getPassword());

            userRepositoty.save(user);
            return true;
        }catch (Exception e){
            System.out.println("Error insert user " + e.getMessage());
            return false;
        }
    }
}
