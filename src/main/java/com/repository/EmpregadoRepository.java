package com.repository;

import com.model.Empregado;
import org.springframework.data.repository.CrudRepository;

public interface EmpregadoRepository extends CrudRepository<Empregado, Long>{
}
