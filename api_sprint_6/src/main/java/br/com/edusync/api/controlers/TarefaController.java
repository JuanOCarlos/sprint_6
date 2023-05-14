package br.com.edusync.api.controlers;

import br.com.edusync.api.models.Tarefa;
import br.com.edusync.api.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping(value = "/novo")
public ResponseEntity novaTarefa(@RequestBody Tarefa tarefa){
    service.adicionar(tarefa);
    return new ResponseEntity(tarefa, HttpStatus.CREATED);
}

@GetMapping(value = "/listar")
public ResponseEntity listarTodos(){
        return new ResponseEntity(service.listarTodos(), HttpStatus.OK);
}

@GetMapping(value = "/listar/{codigo}")
public ResponseEntity listarPorTitulo(@PathVariable Integer codigo){
        return new ResponseEntity(service.buscarPorCodigo(codigo), HttpStatus.OK);
}
@PutMapping(value = "/editar/{codigo}")
public ResponseEntity editar(@PathVariable Integer codigo, @RequestBody Tarefa tarefa){
    service.update(codigo, tarefa);
    return new ResponseEntity(tarefa, HttpStatus.OK);
}

@DeleteMapping(value = "/remover/{codigo}")
public ResponseEntity remover(@PathVariable Integer codigo){
     service.remover(codigo);
     return new ResponseEntity("Tarefa "+ codigo + " excluida com sucesso!", HttpStatus.OK);
}
}
