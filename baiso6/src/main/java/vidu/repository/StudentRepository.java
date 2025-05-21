package vidu.repository;

import vidu.model.Student;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContainingOrEmailContaining(String name, String email, Pageable pageable);
}
