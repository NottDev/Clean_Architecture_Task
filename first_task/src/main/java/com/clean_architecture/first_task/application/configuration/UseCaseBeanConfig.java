package com.clean_architecture.first_task.application.configuration;

import com.clean_architecture.first_task.domain.model.gateways.CourseRepository;
import com.clean_architecture.first_task.domain.model.gateways.StudentRepository;
import com.clean_architecture.first_task.domain.usecase.course.CourseUseCase;
import com.clean_architecture.first_task.domain.usecase.student.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean
    public StudentUseCase studentUseCase(StudentRepository studentRepository){
        return new StudentUseCase(studentRepository);
    }

    @Bean
    public CourseUseCase courseUseCase(CourseRepository courseRepository){
        return new CourseUseCase(courseRepository);
    }
}
