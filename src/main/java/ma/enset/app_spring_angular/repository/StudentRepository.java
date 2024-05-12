package ma.enset.app_spring_angular.repository;

import ma.enset.app_spring_angular.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    Student findByCode(String code);

    List<Student> findByProgramId(String programId);
}
