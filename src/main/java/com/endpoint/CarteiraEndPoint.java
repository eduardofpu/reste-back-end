package com.endpoint;

import com.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@RestController
public class CarteiraEndPoint {

    CarteiraRepository carteiraRepository;

    @Autowired
    public CarteiraEndPoint(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @GetMapping(path = "/carteira")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(carteiraRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/carteira/sum")
    public String sumCarteira(){
        BigDecimal soma = carteiraRepository.fidSumCarteira();

        DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal (true);
        formatoDois.format(soma);

        return formatoDois.format(soma);

    }
}

