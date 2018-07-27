package com.table;

import com.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceNameTableImp implements  ServiceNameTable{

    @Autowired
    private RepositoryNameTable repositoryNameTable;

    @Override
    public List<NameTabela> listAll() {
        return repositoryNameTable.findAll();
    }

    @Override
    public NameTabela createNameTable(NameTabela name) {
        return repositoryNameTable.save(name);
    }

    @Override
    public NameTabela updateNameTable(NameTabela name) {
        verifyIfStudentExists(name.getId());
        return repositoryNameTable.save(name);
    }

    @Override
    public void deleteNameTable(Long id) {
        verifyIfStudentExists(id);
        repositoryNameTable.delete(id);
    }

    private void verifyIfStudentExists(Long id) {
        if (repositoryNameTable.findOne(id) == null) {
            throw new ResourceNotFoundException("Name Table not found for ID: " + id);
        }
    }
}
