package com.clean_architecture.first_task.infraestructure.adapters.jpa.student.entity;

import com.clean_architecture.first_task.domain.model.student.*;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity.CourseDBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class StudentDBO {

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseDBO course;

    public StudentDBO() {}

    public static StudentDBO fromDomain(Student student) {
        return new StudentDBO(
                student.getId().getValue(),
                student.getName().getValue(),
                student.getPhone().getValue(),
                student.getEmail().getValue(),
                CourseDBO.fromDomain(student.getCourse())
        );
    }

    public static Student toDomain(StudentDBO studentDBO){
        return new Student(
                new StudentId(studentDBO.id),
                new StudentName(studentDBO.name),
                new StudentPhone(studentDBO.phone),
                new StudentEmail(studentDBO.email),
                CourseDBO.toDomain(studentDBO.getCourse())
        );
    }
}
