package com.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ibge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String nome;


    @OneToOne
    @JoinColumn(name = "ufId")
    private UfIbge uf;

    @OneToOne
    @JoinColumn(name = "regiaoId")
    private RegiaoIbge regiao;

}
