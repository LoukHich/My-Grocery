package com.ensah.mygroceryapp.services;

import com.ensah.mygroceryapp.models.Product;

import java.util.List;

public interface IlistCourseSerivice {

     void addProductToCourse(String courseName ,String productName);

     List<Product> getAllProductOfCourse(String courseName);

     int getNumberOfProductInCourse(String courseName, String prodName);

     void addProdToCourse(String courseName ,String productName,int repeat);
}
