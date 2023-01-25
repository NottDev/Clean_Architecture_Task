package com.clean_architecture.first_task.infraestructure.entrypoints.student;

import com.clean_architecture.first_task.domain.model.student.dto.StudentDTO;
import com.clean_architecture.first_task.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {
    private final StudentUseCase studentUseCase;

    @GetMapping
    public List<StudentDTO> courseDTO(){
        return studentUseCase.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentUseCase.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getAllByCourse(@PathVariable(name = "id") Long id){
        List<StudentDTO> list = studentUseCase.getByCourse(id);

        if(list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?>
    saveStudent(@RequestBody StudentDTO studentDTO){
        try {
            return new ResponseEntity<>(studentUseCase.saveStudent(studentDTO), HttpStatus.CREATED);
        } catch (NullPointerException e){
            return new ResponseEntity<>("Please enter a valid course.", HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PutMapping
    public ResponseEntity<?>
    updateStudent(@RequestBody StudentDTO studentDTO){
        try {
            return new ResponseEntity<>(studentUseCase.updateStudent(studentDTO), HttpStatus.CREATED);
        } catch (NullPointerException e){
            return new ResponseEntity<>("Please enter a valid course.", HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping
    public ResponseEntity<?>
    deleteStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentUseCase.deleteStudent(studentDTO), HttpStatus.OK);
    }
}
