package com.ensah.mygroceryapp.controller;

import com.ensah.mygroceryapp.models.Product;

import com.ensah.mygroceryapp.services.IListCourseSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class GroceryApi {
     @Autowired
     private IListCourseSerivice listCourseService;
     @GetMapping("/test")
     public String test(){
         return "Bonjour  Nadori ";
     }
    @GetMapping("/products/{courseName}")
    List<Product> getProductsOFCourse(@ PathVariable("courseName") String courseName){

        System.out.println("=====> GET: /products/"+courseName);
        return  listCourseService.getAllProductOfCourse(courseName);


    }

}
