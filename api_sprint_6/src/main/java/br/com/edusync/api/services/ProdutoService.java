package br.com.edusync.api.services;

import br.com.edusync.api.models.Produto;
import br.com.edusync.api.repositories.ProdutoRepository;
import br.com.edusync.api.repositories.criteria.params.ProdutoFilterParam;
import br.com.edusync.api.repositories.criteria.params.ProdutoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    public void adicionar(Produto produtoQueSeraSalvo) {
       produtoRepository.save(produtoQueSeraSalvo);

    }

    public List<Produto> listarTudo() {
        return produtoRepository.findAll();
    }
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoRepositoryCustom produtoRepositoryCustom;

    public Produto buscaPorCodigo(Integer codigo) {
        Optional<Produto> optProduto = produtoRepository.findById(codigo);
        if (optProduto.isEmpty()){
            throw new RuntimeException("Produto não encontrado?");
        }
        return optProduto.get();

    }

    public void update(Integer codigo, Produto produto) {
        if (produtoRepository.existsById(codigo)){
            produtoRepository.save(produto);
        }
    }

    public void remover(Integer codigo) {
        Produto produtoPesquisa = buscaPorCodigo(codigo);
        if (produtoRepository.existsById(codigo)){
            produtoRepository.deleteById(codigo);
        }
    }

    public List<Produto> listarPorNome(String descricaoDaBusca) {
        return produtoRepository.findByDescricaoContainingIgnoreCase(descricaoDaBusca);
    }

    public List<Produto> tiltrar(ProdutoFilterParam params) {
        return produtoRepositoryCustom.get(params);
    }
}