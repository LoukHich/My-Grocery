package com.ensah.mygroceryapp.repo;

import com.ensah.mygroceryapp.models.Registre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registre, Long> {
    int countByCourseNameAndProductName(String courseName, String productName);

    List<Registre> findByCourseNameAndProductName(String courseName, String productName);

}
