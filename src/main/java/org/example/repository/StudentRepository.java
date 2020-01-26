package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
