package com.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Departamento {
    //Relaçao de tabelas muitos para um
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long did;
    private String name;



}

