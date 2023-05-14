package br.com.edusync.api.repositories;

import br.com.edusync.api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    public List<Produto> findByDescricaoContainingIgnoreCase(String descricao);
    public Produto findByDescricaoAndDataValidade(String descricao, LocalDate dataValidade);
}
