package br.com.edusync.api.services;

import br.com.edusync.api.models.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefaQueSeraSalva) {
        tarefas.add(tarefaQueSeraSalva);
    }

    public List<Tarefa> listarTodos() {
        return tarefas;
    }

    public Tarefa buscarPorCodigo(Integer codigo){
        return tarefas.stream().filter(p -> codigo.equals(p.getCodigo())).findFirst().orElseThrow();
    }

    public void update(Integer codigo, Tarefa tarefa) {
        remover(codigo);
        adicionar(tarefa);
    }

    public void remover(Integer codigo){
        Tarefa pesquisaTarefa = buscarPorCodigo(codigo);
        if (pesquisaTarefa != null){
            tarefas.remove(pesquisaTarefa);
        }
    }

}
