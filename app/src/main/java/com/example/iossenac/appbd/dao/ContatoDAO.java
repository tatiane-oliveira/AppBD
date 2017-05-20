package com.example.iossenac.appbd.dao;

import com.example.iossenac.appbd.model.Contato;

import java.util.List;

/**
 * Created by iossenac on 20/05/17.
 */

public interface ContatoDAO {

    void inserir (Contato contato);
    void excluir (Contato contato);
    void atualizar (Contato contato);
    List<Contato> listar();
    Contato procurarPorId(int id);

}
