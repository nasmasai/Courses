package com.bbit2;

import com.bbit2.Models.Course;
import com.bbit2.Models.University;
import com.bbit2.Repository.CourseRepository;
import com.bbit2.Repository.UniversityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class DummyData implements CommandLineRunner {


    public DummyData(UniversityRepository universityController, CourseRepository courseRepository) {
        this.universityRepository = universityController;
        this.courseRepository = courseRepository;

    }

    private final UniversityRepository universityRepository;
    private final CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        University jkuat = new University("JKUAT", "JUJA");
        University strathmore = new University("strathmore", "Olesangale");

        universityRepository.saveAll(Arrays.asList(strathmore, jkuat));


        Course course1 = new Course("API", strathmore);
        courseRepository.save(course1);
        Course course2 = new Course("Ethics", strathmore);
        courseRepository.save(course2);

    }

}
