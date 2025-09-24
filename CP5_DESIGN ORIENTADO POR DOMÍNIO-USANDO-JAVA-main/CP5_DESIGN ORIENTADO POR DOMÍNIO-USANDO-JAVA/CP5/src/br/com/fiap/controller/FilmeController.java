package br.com.fiap.controller;

/*
Felipe Ishii 565339
Vitória Rodrigues 565160
Rodrigo Carvalho 565162
Augusto Bonomo 565155
Nathanael Vieira 564990
 */

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirFilme(String titulo, String genero, String produtora) throws  ClassNotFoundException, SQLException {
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO = new FilmeDAO(con);

        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws  ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirFilme(int codigo) throws  ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public ArrayList<Filme> listarTodosFilmes() throws  ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> resultado = filmeDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

}
