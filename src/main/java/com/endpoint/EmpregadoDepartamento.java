package com.endpoint;

import com.error.ResourceNotFoundException;
import com.model.Departamento;
import com.model.Empregado;
import com.repository.DepartamentoRepository;
import com.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departamento")
public class EmpregadoDepartamento {

    private final EmpregadoRepository empregadoRepository;
    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public EmpregadoDepartamento(EmpregadoRepository empregadoRepository, DepartamentoRepository departamentoRepository) {
        this.empregadoRepository = empregadoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping(path = "/v1/emp")
    public  ResponseEntity<?> findAllEmpregados(){

        return new ResponseEntity<>(empregadoRepository.findAll(),HttpStatus.OK);

    }

    @GetMapping(path = "/v1/dep")
    public  ResponseEntity<?> findAllDep(){

        return new ResponseEntity<>(departamentoRepository.findAll(),HttpStatus.OK);

    }


    @GetMapping(path = "/v1/dep/{id}")
    public  ResponseEntity<?> findOneDep(@PathVariable("id") Long id){
        verifyIfStudentExistsDep(id);
        Departamento departamento = departamentoRepository.findOne(id);

        return new ResponseEntity<>(departamento,HttpStatus.OK);

    }

    @GetMapping(path = "/v1/emp/{id}")
    public  ResponseEntity<?> findOneEmp(@PathVariable("id") Long id){
        verifyIfStudentExistsEmp(id);
        Empregado empregado = empregadoRepository.findOne(id);

        return new ResponseEntity<>(empregado,HttpStatus.OK);

    }


    @PostMapping(path = "/saveD")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> salvarDepartamento(@RequestBody Departamento departamento){

        return new ResponseEntity<>(departamentoRepository.save(departamento), HttpStatus.OK);
    }

    @PostMapping(path = "/saveE")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> salvarEmpregado(@RequestBody  Empregado empregado){

        return new ResponseEntity<>(empregadoRepository.save(empregado), HttpStatus.OK);
    }


    private void verifyIfStudentExistsDep(Long id){
        if(departamentoRepository.findOne(id) == null){

            throw new ResourceNotFoundException(" not found for ID: "+id);
        }
    }

    private void verifyIfStudentExistsEmp(Long id){
        if(empregadoRepository.findOne(id) == null ){

            throw new ResourceNotFoundException(" not found for ID: "+id);
        }
    }


}
