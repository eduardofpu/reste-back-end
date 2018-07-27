package com.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
public class ControllerNameTable {

    @Autowired
    private ServiceNameTable serviceNameTable;

    @GetMapping(path = "/get-all")
    private List<NameTabela> listAll(){
        return serviceNameTable.listAll();
    }

    @PostMapping(path = "/save-name")
    private NameTabela createNameTable(@RequestBody NameTabela name){
        return serviceNameTable.createNameTable(name);
    }

    @PutMapping(path = "/update-name")
    private NameTabela updateNameTable(@RequestBody NameTabela name){
        return serviceNameTable.createNameTable(name);
    }

    @DeleteMapping(path = "/delete-name/{id}")
    private void deleteNameTable(@PathVariable Long id){
       serviceNameTable.deleteNameTable(id);
    }
}
