package com.endpoint;

import com.repository.IbgeRepository;
import com.repository.RegiaoIbgeRepository;
import com.repository.UfibgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ibge" )
public class IbgeEndPoint {

    private final IbgeRepository ibgeRepository;
    private final UfibgeRepository ufibgeRepository;
    private final RegiaoIbgeRepository regiaoIbgeRepository;

    @Autowired
    public IbgeEndPoint(IbgeRepository ibgeRepository, UfibgeRepository ufibgeRepository, RegiaoIbgeRepository regiaoIbgeRepository) {
        this.ibgeRepository = ibgeRepository;
        this.ufibgeRepository = ufibgeRepository;
        this.regiaoIbgeRepository = regiaoIbgeRepository;
    }
    @GetMapping(path = "/ibgeId")
    public ResponseEntity<?> fidAllIbge(){
        return new ResponseEntity<>(ibgeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/ibgeId/{id}")
    public ResponseEntity<?> fidOneIbge(@PathVariable("id") Long id){
        return new ResponseEntity<>(ibgeRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping(path = "/ufId")
    public ResponseEntity<?> fidAllUfIbge(){
        return new ResponseEntity<>(ufibgeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/regiaoId")
    public ResponseEntity<?> fidAllRegiaoIbge(){
        return new ResponseEntity<>(regiaoIbgeRepository.findAll(), HttpStatus.OK);
    }


}
