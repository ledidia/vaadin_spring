package org.example.repository;

import org.example.entity.Curs;
import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursRepository extends JpaRepository<Curs, Integer> {
   @Query("Select s  from Curs c left join c.students s where c.cursId =?1 ")
   List<Student> numberStudentForCurs(Integer idCurs);
}
