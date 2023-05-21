package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
// Cho phpes domain khác gọi vào link API
// White List
// Black List
@CrossOrigin
public class HomeController {

    @Autowired
    private HomeService homeService;

    // Cần phải xác định được kiểu JSON trả ra cho bên FE và để tiện cho BE xử lý chức năng sau này

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setData(homeService.getAllCategory());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Viết API lấy toàn bộ danh sách sản phẩm theo category id
    // Bước 1: xác định dduojcw kiểu JSON trả cho bên Front End

    @GetMapping ("/categoryid")
    public ResponseEntity<?> getCategoryByID(@PathVariable int Id){
        BaseResponse response = new BaseResponse();
        response.setData(homeService.getCategoryById(Id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
