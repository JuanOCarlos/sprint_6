package br.com.edusync.api.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tb_telefone")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private String numeroTelefone;

    @ManyToOne
    private Pessoa pessoa;
}
