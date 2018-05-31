package com.endpoint;

import com.error.CustomErrorType;
import com.model.Studente;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import static com.model.Studente.*;

@RestController
@RequestMapping("students")
public class StudentEndPoint {

    private final DateUtil dateUtil;

    @Autowired
    public StudentEndPoint(DateUtil dateUtil){
        this.dateUtil = dateUtil;

    }
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> listAll() {

        //System.out.println("----------"+dateUtil.formatLocalDatabaseSyle(LocalDateTime.now())+"----------");
      return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentId(@PathVariable("id") int id) {
        Studente student = new Studente();
        student.setId(id);
        int index = studentList.indexOf(student);

        if(index == -1){

            return new ResponseEntity<>(new CustomErrorType("Student not found"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentList.get(index),HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Studente studente) {
        studentList.add(studente);
        return  new ResponseEntity<>(studente,HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Studente studente) {
        studentList.remove(studente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Studente studente) {
        studentList.remove(studente);
        studentList.add(studente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
