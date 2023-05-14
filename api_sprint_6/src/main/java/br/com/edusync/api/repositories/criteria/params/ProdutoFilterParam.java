package br.com.edusync.api.repositories.criteria.params;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProdutoFilterParam {

    private String descricao;
    private BigDecimal precoVenda;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataValidade;

}
