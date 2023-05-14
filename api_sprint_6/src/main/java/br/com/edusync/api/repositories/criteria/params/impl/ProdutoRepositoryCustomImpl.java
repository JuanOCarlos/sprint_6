package br.com.edusync.api.repositories.criteria.params.impl;

import br.com.edusync.api.models.Produto;
import br.com.edusync.api.repositories.criteria.params.ProdutoFilterParam;
import br.com.edusync.api.repositories.criteria.params.ProdutoRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {

    private EntityManager entityManager;

    public ProdutoRepositoryCustomImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Produto> get(ProdutoFilterParam produtoFilterParam) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> produtoCriteriaQuery = criteriaBuilder.createQuery(Produto.class);

        Root<Produto> produtoRoot = produtoCriteriaQuery.from(Produto.class);
        List<Predicate> predicates = new ArrayList<>();

        if ( produtoFilterParam.getDescricao() != null ){
            predicates.add(criteriaBuilder.like(produtoRoot.get("descricao"), "&" + produtoFilterParam.getDescricao() + "&"));
        }
        if ( produtoFilterParam.getDataValidade() != null ){
            predicates.add(criteriaBuilder.equal(produtoRoot.get("dataValidade"), produtoFilterParam.getDataValidade()));
        }
        if ( produtoFilterParam.getPrecoVenda() != null ){
            predicates.add(criteriaBuilder.equal(produtoRoot.get("precoVenda"), produtoFilterParam.getPrecoVenda()));
        }


        if (predicates.isEmpty()){
            produtoCriteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<Produto> queryResult = this.entityManager.createQuery(produtoCriteriaQuery);
        return queryResult.getResultList();
    }
}
