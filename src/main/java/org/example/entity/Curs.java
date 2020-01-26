package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cursId;
    private String denumirea;
    @OneToMany(mappedBy = "cursDenumirea")
    private List<NoteCurs> notes =new ArrayList<>();
    @ManyToMany(mappedBy = "curs")
    private List<Student> students =new ArrayList<>();
    public Integer getCursId() {
        return cursId;
    }

    public void setCursId(Integer cursId) {
        this.cursId = cursId;
    }

    public String getDenumirea() {
        return denumirea;
    }

    public void setDenumirea(String denumirea) {
        this.denumirea = denumirea;
    }

    public List<NoteCurs> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteCurs> notes) {
        this.notes = notes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
