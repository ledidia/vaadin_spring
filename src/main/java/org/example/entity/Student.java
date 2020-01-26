package org.example.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public  class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirthDay;
    @ManyToMany()
private List<Curs> curs = new ArrayList<>();
    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(LocalDate dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public List<Curs> getCurs() {
        return curs;
    }

    public void setCurs(List<Curs> curs) {
        this.curs = curs;
    }
}
