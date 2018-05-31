package com.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;



@ToString
@AllArgsConstructor//cria contrutor padrao
@NoArgsConstructor// cria contrutor vazio
public class Studente {


    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    public static List<Studente> studentList;

    static {
        studenteRepository();
    }
/*
    public Studente(int id, String name) {
        this(name);
        this.id = id;
    }
    public Studente(String name) {
        this.name = name;
    }

    public Studente() {
    }*/

    private static void studenteRepository(){
        studentList = new ArrayList<>(asList(new Studente(1,"Deku"),new Studente(2,"Todoroki")));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studente studente = (Studente) o;
        return id == studente.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
