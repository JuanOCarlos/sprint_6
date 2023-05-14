package br.com.edusync.api.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tb_pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "primeiro_nome")
    private String nome;
    private String sobreNome;

}
