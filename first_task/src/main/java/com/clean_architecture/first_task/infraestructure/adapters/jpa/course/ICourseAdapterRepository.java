package com.clean_architecture.first_task.infraestructure.adapters.jpa.course;

import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity.CourseDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseAdapterRepository extends JpaRepository<CourseDBO, Long> {
}
