package com.repository;

import com.model.StudenteEnty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudenteEnty, Long> {
    List<StudenteEnty> findByNameIgnoreCaseContaining(String name);
}
