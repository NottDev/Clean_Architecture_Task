package com.clean_architecture.first_task.domain.model.gateways;

import com.clean_architecture.first_task.domain.model.course.Course;

import java.util.List;

public interface CourseRepository {
    Course saveCourse(Course course);
    String updateCourse(Course course);
    String deleteCourse(Course course);
    List<Course> getAll();
    Course findCourseById(Long id);
}
