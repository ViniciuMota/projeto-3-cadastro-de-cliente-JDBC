package main.java.br.com.dao.jdbc.dao;

import main.java.br.com.domen.Produto;

import java.util.List;

public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws Exception;

    Integer atualizar(Produto produto) throws Exception;

    Produto buscar(String codigo) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Integer excluir(Produto produto) throws Exception;
}
