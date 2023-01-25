package com.clean_architecture.first_task.domain.model.student.dto;

import com.clean_architecture.first_task.domain.model.course.Course;
import com.clean_architecture.first_task.domain.model.course.dto.CourseDTO;
import com.clean_architecture.first_task.domain.model.student.*;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity.CourseDBO;

import javax.validation.constraints.NotBlank;

public class StudentDTO {
    private Long id;
    private String name;
    private Integer phone;
    private String email;
    private CourseDTO course;
    public StudentDTO(){}

    public StudentDTO(Long id, String name, Integer phone, String email, CourseDTO course) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public static StudentDTO fromDomainToDTO(Student student){
        return new StudentDTO(
                student.getId().getValue(),
                student.getName().getValue(),
                student.getPhone().getValue(),
                student.getEmail().getValue(),
                CourseDTO.fromDomainToDTO(student.getCourse())
        );
    }

    public static Student toDomainFromDTO(StudentDTO studentDTO){
        return new Student(
                new StudentId(studentDTO.getId()),
                new StudentName(studentDTO.getName()),
                new StudentPhone(studentDTO.getPhone()),
                new StudentEmail(studentDTO.getEmail()),
                CourseDTO.toDomainFromDTO(studentDTO.getCourse())
        );
    }
}
