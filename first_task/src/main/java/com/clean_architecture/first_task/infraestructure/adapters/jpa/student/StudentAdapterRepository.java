package com.clean_architecture.first_task.infraestructure.adapters.jpa.student;

import com.clean_architecture.first_task.domain.model.gateways.StudentRepository;
import com.clean_architecture.first_task.domain.model.student.Student;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.ICourseAdapterRepository;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.course.entity.CourseDBO;
import com.clean_architecture.first_task.infraestructure.adapters.jpa.student.entity.StudentDBO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentAdapterRepository implements StudentRepository {

    private final IStudentAdapterRepository IStudentAdapterRepository;
    private final ICourseAdapterRepository iCourseAdapterRepository;
    public StudentAdapterRepository(IStudentAdapterRepository IStudentAdapterRepository, ICourseAdapterRepository iCourseAdapterRepository) {
        this.IStudentAdapterRepository = IStudentAdapterRepository;
        this.iCourseAdapterRepository = iCourseAdapterRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        StudentDBO toDbo = StudentDBO.fromDomain(student);
        Optional<CourseDBO> courseDBO = iCourseAdapterRepository.findById(toDbo.getCourse().getId());
        if (courseDBO.isEmpty()){
            throw new NoSuchElementException("Course not found.");
        }
        return StudentDBO.toDomain(IStudentAdapterRepository.save(toDbo));
    }

    @Override
    public String updateStudent(Student student) {
        StudentDBO toDbo = StudentDBO.fromDomain(student);

        Optional<CourseDBO> courseDBO = iCourseAdapterRepository.findById(toDbo.getCourse().getId());
        if (courseDBO.isEmpty()){
            throw new NoSuchElementException("Course not found.");
        }

        boolean studentChecker = IStudentAdapterRepository.existsById(toDbo.getId());

        if (studentChecker){
            try{
                IStudentAdapterRepository.save(toDbo);
                return "Student updated successfully.";
            } catch (EntityNotFoundException e){
                return "Student not found.";
            }
        }
        else {
            return "Student not found.";
        }
    }

    @Override
    public String deleteStudent(Student student) {
        StudentDBO toDbo = StudentDBO.fromDomain(student);
        boolean studentChecker = IStudentAdapterRepository.existsById(toDbo.getId());

        if (studentChecker) {
            IStudentAdapterRepository.delete(toDbo);
        }

        studentChecker = IStudentAdapterRepository.existsById(toDbo.getId());

        if(studentChecker) {
            return "Student deleted successfully";
        }
        else {
            return "Student not found";
        }
    }

    @Override
    public List<Student> getAll() {
        List<StudentDBO> list = (List<StudentDBO>) IStudentAdapterRepository.findAll();
        return list.stream()
                .map(StudentDBO::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getByCourse(Long id) {
        return IStudentAdapterRepository.findByCourseId(id)
                .stream()
                .map(StudentDBO::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Student findStudentById(Long id) {
        Optional<StudentDBO> value = IStudentAdapterRepository.findById(id);
        if(value.isEmpty()){
            throw new NoSuchElementException(String.format("Student with id %d hasn't been found.", id));
        }
        return StudentDBO.toDomain(value.get());
    }

}
