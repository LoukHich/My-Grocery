package com.ensah.mygroceryapp;

import com.ensah.mygroceryapp.models.CourseList;
import com.ensah.mygroceryapp.models.Product;
import com.ensah.mygroceryapp.repo.CourseListRepo;
import com.ensah.mygroceryapp.repo.ProductRepo;
import com.ensah.mygroceryapp.repo.RegistrationRepo;
import com.ensah.mygroceryapp.services.IlistCourseSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication

public class MyGroceryAppApplication {
    @Autowired
    private IlistCourseSerivice courseService;


    public static void main(String[] args) {
        SpringApplication.run(MyGroceryAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CourseListRepo courseListRepo, ProductRepo productRepo, RegistrationRepo registrationRepo) {
        return args -> {
            System.out.println("start......");
            //Save product
            Product prod1 = new Product();
            prod1.setName("Lait");

            Product prod2 = new Product();
            prod2.setName("Oeuf");

            Product prod3 = new Product();
            prod3.setName("Kiri");

            Product prod4 = new Product();
            prod4.setName("Orange");
            productRepo.save(prod1);
            productRepo.save(prod2);
            productRepo.save(prod3);
            productRepo.save(prod4);
            //--------------------------------------------------------------------------------

            CourseList course1 = new CourseList();
            course1.setName("Liste Course 1");
            courseListRepo.save(course1);

            CourseList course2 = new CourseList();
            course2.setName("Liste Course 2");
            courseListRepo.save(course2);
            //-----------------------------------------------------------------------------------
            courseService.addProductToCourse("Liste Course 1", "Lait"); //(1,1)
            courseService.addProductToCourse("Liste Course 1", "Oeuf"); //(1,2)
            courseService.addProdToCourse("Liste Course 1", "Kiri", 3);//(1,3) *3
            courseService.addProductToCourse("Liste Course 1", "Orange");//(1,4)
            courseService.addProductToCourse("Liste Course 2", "Lait");//(2,1)
            courseService.addProductToCourse("Liste Course 2", "Oeuf");//(2,2)


            Stream.of("Liste Course 1", "Liste Course 2").forEach(list -> {
                String output = String.format("%s :  ", list);
                System.out.println(output);
                courseService.getAllProductOfCourse(list).stream()
                        .forEach(prod -> {
                                    System.out.println("Produit: " + prod.getName() + " |  Nombre: " + courseService.getNumberOfProductInCourse(list, prod.getName()));
                                }

                        );

            });

            System.out.println(productRepo.countDistinctByRegistresCourseName("Liste Course 2"));
            System.out.println("Finish......");
            //System.out.println(courseRegistrationRepo.getByCourseIdAndProductId(2l,2l));
//            System.out.println(courseRegistrationRepo.getByCourseIdAndProductId(2l,1l).stream().count());
//            System.out.println(courseRegistrationRepo.countByCourseIdAndProductId(2l,2l));
//            System.out.println(courseRegistrationRepo.countByCourseIdAndProductId(2l,1l));
//            List<Product> pds= productRepo.findProductByCourseRegistrationsCourseId(2l);
//            pds.forEach(e-> System.out.println(e.getPrductName()));
            // get Number of product in Liste course
//            System.out.println(courseRegistrationRepo.countByCourseNameAndProductName("Liste Course 1","Lait"));
//            System.out.println(courseRegistrationRepo.countByCourseNameAndProductName("Liste Course 1","Oeuf"));
//            System.out.println(courseRegistrationRepo.countByCourseNameAndProductName("Liste Course 1","Kiri"));
            //  get  Products of  Liste course
//            productRepo.findByRegistresCourseName("Liste Course 2").forEach(p-> System.out.println(p.getName()));
            //      courseListRepo.findByRegistresProductName("Lait").forEach(c -> System.out.println(c.getName()));

        };
    }

}
