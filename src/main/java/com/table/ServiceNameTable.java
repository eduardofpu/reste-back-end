package com.table;

import java.util.List;

public interface ServiceNameTable {

    List<NameTabela> listAll();
    NameTabela createNameTable(NameTabela name);
    NameTabela updateNameTable(NameTabela name);
    void deleteNameTable(Long id);
}
