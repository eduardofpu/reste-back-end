package com.repository;

import com.model.StudenteEnty;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//Essa interface extend o Crud repository e possui metodos para paginação
public interface StudentRepositoryPagination extends PagingAndSortingRepository<StudenteEnty,Long> {
    List<StudenteEnty> findByNameIgnoreCaseContaining(String name);
}
