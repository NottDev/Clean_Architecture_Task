package com.clean_architecture.first_task.domain.usecase.student;

import com.clean_architecture.first_task.domain.model.gateways.StudentRepository;
import com.clean_architecture.first_task.domain.model.student.dto.StudentDTO;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.student.entity.StudentDBO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final StudentRepository studentRepository;
    public StudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        return StudentDTO.fromDomainToDTO(studentRepository.saveStudent(StudentDTO.toDomainFromDTO(studentDTO)));
    }

    public String updateStudent(StudentDTO studentDTO){
        return studentRepository.updateStudent(StudentDTO.toDomainFromDTO(studentDTO));
    }

    public String deleteStudent(StudentDTO studentDTO){
        return studentRepository.deleteStudent(StudentDTO.toDomainFromDTO(studentDTO));
    }

    public List<StudentDTO> getAll(){
        return studentRepository.getAll()
                .stream()
                .map(StudentDTO::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id){
        return StudentDTO.fromDomainToDTO(studentRepository.findStudentById(id));
    }

    public List<StudentDTO> getByCourse(Long id){
        return studentRepository.getByCourse(id)
                .stream()
                .map(StudentDTO::fromDomainToDTO)
                .collect(Collectors.toList());
    }
}
