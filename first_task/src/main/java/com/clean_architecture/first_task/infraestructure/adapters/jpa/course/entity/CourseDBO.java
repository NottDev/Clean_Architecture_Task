package com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity;

import com.clean_architecture.first_task.domain.model.course.Course;
import com.clean_architecture.first_task.domain.model.course.CourseId;
import com.clean_architecture.first_task.domain.model.course.CourseName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class CourseDBO {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    public CourseDBO() {}

    public static CourseDBO fromDomain(Course course) {
        return new CourseDBO(
                course.getId().getValue(),
                course.getName().getValue()
        );
    }

    public static Course toDomain(CourseDBO courseDBO){
        return new Course(
                new CourseId(courseDBO.id),
                new CourseName(courseDBO.name)
        );
    }
}
