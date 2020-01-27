package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("Select s.firstName, s.lastName, c.denumirea, n.nota1,n.nota2, n.nota3  from Student s inner join s.curs c inner join c.notes n")
     List<Object[]> studentCursNote();
}
