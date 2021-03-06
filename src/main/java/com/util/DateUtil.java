package com.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component//mapeada pelo componente scan
//@Repository // especialização do component para trabalhar com Dao
//@Service    // especialização do component para trabalhar com camada de servico
public class DateUtil {
    public String formatLocalDatabaseSyle(LocalDateTime locaDatetime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(locaDatetime);
    }
}
