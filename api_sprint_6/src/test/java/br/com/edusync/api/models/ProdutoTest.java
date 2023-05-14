package br.com.edusync.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void testaFieldDescricao(){

        //prepara
        Produto prod = new Produto();
        //executa
        prod.setDescricao("teste1");
        //valida
        Assertions.assertEquals("teste1",prod.getDescricao());
    }
}
