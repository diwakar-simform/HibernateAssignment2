package com.hibernate.AssignmentTwo.service.course;

import com.hibernate.AssignmentTwo.entities.course.Course;
import com.hibernate.AssignmentTwo.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        course.getReviews().forEach(review -> review.setCourse(course));
        return courseRepo.save(course);
    }

    @Override
    public String deleteCourseById(Long id) {
        String message = "------Wrong Id------";
        if (id != null && id > 0) {
            courseRepo.deleteById(id);
            message = "------Item deleted Successfully-------";
        }
        return message;
    }

}
