package com.endpoint;

import com.error.ResourceNotFoundException;
import com.model.StudenteEnty;
import com.repository.StudentRepositoryPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("estudantepage")
public class EstudantePage{

    private final StudentRepositoryPagination studentDao;

    @Autowired
    public EstudantePage(StudentRepositoryPagination studentDao){
        this.studentDao = studentDao;

    }
    //localhost:8080/estudantepage?sort=name,asc localhost:8080/estudantepage?sort=name,desc
    @GetMapping //localhost:8080/estudantepage?page=1 localhost:8080/estudantepage?page=0&size=4
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(studentDao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentId(@PathVariable("id") Long id) {
        verifyIfStudentExists(id);
        StudenteEnty studente =  studentDao.findOne(id);
        return new ResponseEntity<>(studente,HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findBStudentByName(@PathVariable String name){
        return new ResponseEntity<>(studentDao.findByNameIgnoreCaseContaining(name),HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)// So faz rooback quando nao tem execepiton do tipo runtime
    public ResponseEntity<?> save(@Valid @RequestBody StudenteEnty studente) {

        return  new ResponseEntity<>(studentDao.save(studente),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfStudentExists(id);
        studentDao.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteall")
    public  ResponseEntity<?> deleteAll(){
        studentDao.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StudenteEnty studente) {
        verifyIfStudentExists(studente.getId());
        studentDao.save(studente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/contador")
    public ResponseEntity<?> contador(){
        Long contador = studentDao.count();
        String cont = String.valueOf("Total de elementos no banco de dados = "+contador);
        System.out.println(cont);
        return new ResponseEntity<>(cont,HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){
        if(studentDao.findOne(id) == null){

            throw new ResourceNotFoundException("Student not found for ID: "+id);
        }
    }


}
