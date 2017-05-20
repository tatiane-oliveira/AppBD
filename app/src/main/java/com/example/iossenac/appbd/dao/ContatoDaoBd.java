package com.example.iossenac.appbd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.iossenac.appbd.model.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iossenac on 20/05/17.
 */

public class ContatoDaoBd implements ContatoDAO {

    private Banco base;
    private ContentValues valores;
    private SQLiteDatabase banco;

    public ContatoDaoBd(Context context) {
        base = new Banco(context);
    }

    @Override
    public void inserir(Contato contato) {
        banco = base.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", contato.getNome());
        valores.put("telefone", contato.getTelefone());
        banco.insert("contato", null, valores);
        banco.close();
    }

    @Override
    public void excluir(Contato contato) {

    }

    @Override
    public void atualizar(Contato contato) {

    }

    @Override
    public List<Contato> listar() {
        banco = base.getReadableDatabase();
        Cursor cursor = banco.query("contato", new String[]{"id", "nome", "telefone"}, null, null, null, null, "id");
        List<Contato> contatos = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            contatos.add(new Contato(id, nome, telefone));
        }
        banco.close();
        return contatos;
    }

    @Override
    public Contato procurarPorId(int id) {
        banco = base.getReadableDatabase();
        Cursor cursor = banco.query("contato", new String[]{"id", "nome", "telefone"}, "id = ?", new String[] {String.valueOf(id)}, null, null, "id");
        if (cursor.moveToNext()) {
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            banco.close();
            return new Contato(id, nome, telefone);
        }
        banco.close();
        return null;
    }
}
