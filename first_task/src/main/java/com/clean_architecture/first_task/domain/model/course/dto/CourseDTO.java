package com.clean_architecture.first_task.domain.model.course.dto;

import com.clean_architecture.first_task.domain.model.course.Course;
import com.clean_architecture.first_task.domain.model.course.CourseId;
import com.clean_architecture.first_task.domain.model.course.CourseName;

public class CourseDTO {
    private Long id;
    private String name;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CourseDTO fromDomainToDTO(Course course){
        return new CourseDTO(
                course.getId().getValue(),
                course.getName().getValue()
        );
    }

    public static Course toDomainFromDTO(CourseDTO courseDTO){
        return new Course(
                new CourseId(courseDTO.getId()),
                new CourseName(courseDTO.getName())
        );
    }
}
