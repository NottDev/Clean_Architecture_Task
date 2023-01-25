package com.clean_architecture.first_task.domain.usecase.course;

import com.clean_architecture.first_task.domain.model.course.dto.CourseDTO;
import com.clean_architecture.first_task.domain.model.gateways.CourseRepository;
import com.clean_architecture.first_task.domain.model.student.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CourseUseCase {
    private final CourseRepository courseRepository;

    public CourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO){
        return CourseDTO.fromDomainToDTO(courseRepository.saveCourse(CourseDTO.toDomainFromDTO(courseDTO)));
    }

    public String updateCourse(CourseDTO courseDTO) {
        try {
            return courseRepository.updateCourse(CourseDTO.toDomainFromDTO(courseDTO));
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public String deleteCourse(CourseDTO courseDTO){
        try{
            return courseRepository.deleteCourse(CourseDTO.toDomainFromDTO(courseDTO));
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public List<CourseDTO> getAll(){
        return courseRepository.getAll()
                .stream()
                .map(CourseDTO::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id){
        return CourseDTO.fromDomainToDTO(courseRepository.findCourseById(id));
    }
}
