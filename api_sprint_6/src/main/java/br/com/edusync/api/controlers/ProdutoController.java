package br.com.edusync.api.controlers;


import br.com.edusync.api.models.Produto;
import br.com.edusync.api.repositories.criteria.params.ProdutoFilterParam;
import br.com.edusync.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/produtos")
@RestController
public class ProdutoController {

    // CRUD - (CREATE, READ(TODOS OU UM UNICO REGISTRO), UPDATE, DELETE)
    /*
    * CREATE = POST = cadastrar, enviar dados
    * READ = GET = quer alguma coisa
    * UPDATE = PUT = atualizar
    * DELETE = DELETE = apagar algo
    * */

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/novo")
    public ResponseEntity novoProduto(@RequestBody Produto produto) {
        service.adicionar(produto);
        return new ResponseEntity(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity listarTodos(){

    return new ResponseEntity(service.listarTudo(), HttpStatus.OK);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity listarPorCodigo(@PathVariable Integer codigo){
        try {
            return new ResponseEntity(service.buscaPorCodigo(codigo), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{codigo}")
    public ResponseEntity alterar(@PathVariable Integer codigo, @RequestBody Produto produto){
    service.update(codigo,produto);

    return new ResponseEntity(produto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity remover(@PathVariable Integer codigo){
        service.remover(codigo);
    return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/nome")
    public ResponseEntity listarPorNome(@RequestParam(defaultValue = "") String busca){
        return new ResponseEntity(service.listarPorNome(busca),HttpStatus.OK);
    }

    @GetMapping(value = "/filtro")
    public ResponseEntity filtrar(ProdutoFilterParam params){
        return new ResponseEntity(service.tiltrar(params), HttpStatus.OK);

    }
}
