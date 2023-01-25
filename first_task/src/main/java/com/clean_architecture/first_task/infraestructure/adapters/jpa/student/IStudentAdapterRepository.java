package com.clean_architecture.first_task.infraestructure.adapters.jpa.student;

import com.clean_architecture.first_task.domain.model.student.dto.StudentDTO;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.student.entity.StudentDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentAdapterRepository extends JpaRepository<StudentDBO, Long> {
    List<StudentDBO> findByCourseId(Long id);
}
