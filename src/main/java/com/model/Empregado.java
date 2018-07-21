package com.model;

import lombok.*;

import javax.persistence.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Empregado {
    // Tutotial: https://www.tutorialspoint.com/pg/jpa/jpa_entity_relationships.htm
//Relaçao de tabelas muitos para um
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eid;
    private String ename;
    private double salary;
    private String deg;

    //chave estrangeira do departamento
    @ManyToOne
    @JoinColumn(name = "did")
    private Departamento departamento;
}
//formato do json via postman

/*{
        "eid": 2,
        "ename": "Satish",
        "salary": 45000,
        "deg": "Escritor técnico",
        "departamento": {
        "did": 1,
        "name": "Desenvolvimento"
        }
   }*/
