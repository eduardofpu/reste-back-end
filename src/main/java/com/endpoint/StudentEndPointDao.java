package com.endpoint;

import com.error.CustomErrorType;
import com.model.StudenteEnty;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("studentdao")
public class StudentEndPointDao {

    private final StudentRepository studentDao;

    @Autowired
    public StudentEndPointDao(StudentRepository studentDao){
        this.studentDao = studentDao;

    }
    @GetMapping
    public ResponseEntity<?> listAll() {

        return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentId(@PathVariable("id") Long id) {

        StudenteEnty studente = studentDao.findOne(id);
        if(studente == null){
            return new ResponseEntity<>(new CustomErrorType("Student not found"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studente,HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findBStudentByName(@PathVariable String name){
    return new ResponseEntity<>(studentDao.findByNameIgnoreCaseContaining(name),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudenteEnty studente) {

        return  new ResponseEntity<>(studentDao.save(studente),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")

    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentDao.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StudenteEnty studente) {

        studentDao.save(studente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
