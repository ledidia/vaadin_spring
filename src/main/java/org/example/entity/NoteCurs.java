package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public  class NoteCurs {
    @Id
    @GeneratedValue
    private Integer idNoteCurs;
    private Integer nota1;
    private Integer nota2;
    private Integer nota3;
    @ManyToOne(fetch = FetchType.EAGER)
    private Curs cursDenumirea;

    public Integer getIdNoteCurs() {
        return idNoteCurs;
    }

    public void setIdNoteCurs(Integer idNoteCurs) {
        this.idNoteCurs = idNoteCurs;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Curs getCursDenumirea() {
        return cursDenumirea;
    }

    public void setCursDenumirea(Curs cursDenumirea) {
        this.cursDenumirea = cursDenumirea;
    }

    @Override
    public String toString() {
        return "NoteCurs{" +
                "idNoteCurs=" + idNoteCurs +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", cursDenumirea='" + cursDenumirea + '\'' +
                '}';
    }
}
