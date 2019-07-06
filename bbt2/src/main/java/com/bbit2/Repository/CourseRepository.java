package com.bbit2.Repository;

import com.bbit2.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUniversityId(Long id);
}

