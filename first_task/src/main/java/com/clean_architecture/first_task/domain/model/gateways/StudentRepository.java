package com.clean_architecture.first_task.domain.model.gateways;

import com.clean_architecture.first_task.domain.model.course.Course;
import com.clean_architecture.first_task.domain.model.student.Student;
import com.clean_architecture.first_task.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {
    Student saveStudent(Student student);
    String updateStudent(Student student);
    String deleteStudent(Student student);
    List<Student> getAll();
    List<Student> getByCourse(Long id);
    Student findStudentById(Long id);
}
