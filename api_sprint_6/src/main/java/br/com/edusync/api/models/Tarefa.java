package br.com.edusync.api.models;

import lombok.Data;

@Data
public class Tarefa {

    private Integer codigo;
    private String titulo;
    private String descricao;
    private String dataDeVencimento;

}
