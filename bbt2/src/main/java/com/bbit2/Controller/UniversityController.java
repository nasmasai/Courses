package com.bbit2.Controller;

import com.bbit2.Models.Course;
import com.bbit2.Models.University;
import com.bbit2.NotFoundException;
import com.bbit2.Repository.CourseRepository;
import com.bbit2.Repository.UniversityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/universities
@RestController
@RequestMapping(value = "universities")

public class UniversityController {
    private final UniversityRepository universityRepository;
    private final CourseRepository courseRepository;

    public UniversityController(UniversityRepository universityRepository, CourseRepository courseRepository) {
        this.universityRepository = universityRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {

        return universityRepository.save(university);

    }

    @DeleteMapping(value = "{id}")
    public void deleteUniversity(@PathVariable Long id) {
        University university = findOneById(id);
        universityRepository.deleteById(id);

    }

    @PatchMapping(value = "{id}")
    public University updateUniversity(@PathVariable Long id, @RequestBody University university) {
        University foundUniversity = findOneById(id);
        foundUniversity.setUniversityName(university.getUniversityName());
        foundUniversity.setLocation(university.getLocation());

        return universityRepository.save(foundUniversity);
    }

    @GetMapping(value = "{id}")
    public University findOneById(@PathVariable Long id) {
        University university = universityRepository.findById(id).orElseThrow(() -> new NotFoundException("No university with the id" + id + "was found"));

        return university;
    }


@GetMapping(value = "{universityId}/courses")
public List<Course> findByUniversityId(@PathVariable Long universityId){
return courseRepository.findByUniversityId(universityId);
}
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        return courseRepository.save(course);
    }

    @DeleteMapping(value = "{universityId}/courses")
    public void deleteCourse(@PathVariable Long universityId) {
        List course = (List) findOneById(universityId);
        courseRepository.deleteById(universityId);

    }

    @PatchMapping(value = "{universityId}/courses")
    public void updateCourse(@PathVariable Long universityId, @RequestBody Course course) {
        University foundCourse = findOneById(universityId);
        foundCourse.setUniversityName(course.getCourseName());
    }


    }


