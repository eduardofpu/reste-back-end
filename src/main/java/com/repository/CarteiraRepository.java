package com.repository;

import com.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;


public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    String SUM = "select sum(c.valor) from Carteira c";

    @Query(SUM)
    BigDecimal sumTotalCarteira();



}
