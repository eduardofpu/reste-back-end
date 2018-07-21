package com.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    BigDecimal valor;

    @Builder
    @Getter
    public static class Total{
        String total;
    }
}
