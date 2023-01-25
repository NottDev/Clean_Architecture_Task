package com.clean_architecture.first_task.infraestructure.adapters.jpa.course;

import com.clean_architecture.first_task.domain.model.course.Course;
import com.clean_architecture.first_task.domain.model.gateways.CourseRepository;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity.CourseDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseAdapterRepository implements CourseRepository {
    private final ICourseAdapterRepository ICourseAdapterRepository;

    public CourseAdapterRepository(ICourseAdapterRepository ICourseAdapterRepository) {
        this.ICourseAdapterRepository = ICourseAdapterRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        CourseDBO toDbo = CourseDBO.fromDomain(course);
        return CourseDBO.toDomain(ICourseAdapterRepository.save(toDbo));
    }

    @Override
    public String updateCourse(Course course) {
        CourseDBO toDbo = CourseDBO.fromDomain(course);
        boolean courseChecker = ICourseAdapterRepository.existsById(toDbo.getId());

        if (courseChecker){
            ICourseAdapterRepository.save(toDbo);
            return "Course updated successfully.";
        }
        else {
            return "Course not found.";
        }
    }

    @Override
    public String deleteCourse(Course course) {
        CourseDBO toDbo = CourseDBO.fromDomain(course);
        boolean courseChecker = ICourseAdapterRepository.existsById(toDbo.getId());

        if(courseChecker) { ICourseAdapterRepository.delete(toDbo); }

        courseChecker = ICourseAdapterRepository.existsById(toDbo.getId());

        if(courseChecker) {
            return "Course deleted successfully.";
        }
        else {
            return "Course not found.";
        }

    }

    @Override
    public List<Course> getAll() {
        List<CourseDBO> list = (List<CourseDBO>) ICourseAdapterRepository.findAll();
        return list.stream()
                .map(CourseDBO::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Course findCourseById(Long id){
        Optional<CourseDBO> value = ICourseAdapterRepository.findById(id);
        if(value.isEmpty()){
            throw new NoSuchElementException(String.format("Course with id %d hasn't been found.", id));
        }
        return CourseDBO.toDomain(value.get());
    }
}
