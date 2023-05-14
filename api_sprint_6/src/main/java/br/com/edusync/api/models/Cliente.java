package br.com.edusync.api.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
@Entity(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(length = 150)
    private String razaoSocial;

    @Column(name = "nome_fantasia", length = 200)
    private String nomeFantasia;

    @Column(name = "numero_documento", length = 20)
    private String numeroDocumento;

    @Column(name = "responsavel", length = 100)
    private String numeroResponsavel;
}
