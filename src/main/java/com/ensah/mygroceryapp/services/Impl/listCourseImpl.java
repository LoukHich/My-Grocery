package com.ensah.mygroceryapp.services.Impl;

import com.ensah.mygroceryapp.models.CourseList;
import com.ensah.mygroceryapp.models.Product;
import com.ensah.mygroceryapp.models.Registre;
import com.ensah.mygroceryapp.repo.CourseListRepo;
import com.ensah.mygroceryapp.repo.ProductRepo;
import com.ensah.mygroceryapp.repo.RegistrationRepo;
import com.ensah.mygroceryapp.services.IlistCourseSerivice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class listCourseImpl implements IlistCourseSerivice {

    private final CourseListRepo courseListRepo;
    private final ProductRepo productRepo;
    private final RegistrationRepo registrationRepo;

    @Override
    public void addProductToCourse(String courseName, String productName) {

        CourseList course = courseListRepo.findByName(courseName);
        Product product = productRepo.findByName(productName);

        Registre registre = new Registre();
        registre.setProduct(product);
        registre.setCourse(course);
        registre.setRegisteredAt(LocalDateTime.now());
        registrationRepo.save(registre);


    }

    @Override
    public List<Product> getAllProductOfCourse(String courseName) {
        return productRepo.findByRegistresCourseName(courseName);
    }
    @Override
    public int getNumberOfProductInCourse(String courseName, String prodName) {

           return registrationRepo.countByCourseNameAndProductName(courseName,prodName);
    }

    @Override
    public void addProdToCourse(String courseName, String productName, int repeat) {
        for(int i=0;i<repeat;i++){
            addProductToCourse(courseName,productName);
        }
    }
}
