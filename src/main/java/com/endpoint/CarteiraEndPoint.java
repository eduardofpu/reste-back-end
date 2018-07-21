package com.endpoint;

import com.model.Carteira;
import com.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import static com.model.Carteira.Total;
@RestController
public class CarteiraEndPoint {
    private CarteiraRepository carteiraRepository;

    @Autowired
    public CarteiraEndPoint(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @GetMapping(path = "/carteira")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(carteiraRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/carteira/sum")
    public Total sumCarteira(){
         return totalSumCarteira();
    }

    private  Total total(){
        BigDecimal soma = carteiraRepository.sumTotalCarteira();
        String total = formatTotal(soma);
        return Total.builder()
                .total(total)
                .build();
    }

    private Total totalSumCarteira(){
        String ZERO = "0.00";
        List<Carteira> list = carteiraRepository.findAll();
        if(list.isEmpty()){
            return Total.builder()
                    .total(ZERO)
                    .build();
        }
        return total();
    }

    private String formatTotal(BigDecimal soma) {
        DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal (true);
        return formatoDois.format(soma);
    }

}

