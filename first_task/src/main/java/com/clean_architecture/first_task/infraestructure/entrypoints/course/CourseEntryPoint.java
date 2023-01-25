package com.clean_architecture.first_task.infraestructure.entrypoints.course;

import com.clean_architecture.first_task.domain.model.course.dto.CourseDTO;
import com.clean_architecture.first_task.domain.usecase.course.CourseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseEntryPoint {
    private final CourseUseCase courseUseCase;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CourseDTO> getAll(){
        return courseUseCase.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(courseUseCase.getCourseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>
    saveCourse(@RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(courseUseCase.saveCourse(courseDTO), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    updateCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseUseCase.updateCourse(courseDTO), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<?>
    deleteCourse(@RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(courseUseCase.deleteCourse(courseDTO), HttpStatus.OK);
    }
}
