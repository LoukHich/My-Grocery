package com.ensah.mygroceryapp.repo;

import com.ensah.mygroceryapp.models.CourseList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseListRepo extends JpaRepository<CourseList, Long> {

    List<CourseList> findByRegistresProductName(String pName);

    CourseList findByName(String name);
}
