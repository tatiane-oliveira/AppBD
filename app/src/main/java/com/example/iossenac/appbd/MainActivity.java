package com.example.iossenac.appbd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String createTable = "CREATE TABLE IF NOT EXISTS contato" +
                                        "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "nome VARCHAR(30)," +
                                        "telefone VARCHAR(10));";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase banco = openOrCreateDatabase("contatos.bd", MODE_PRIVATE, null);
        banco.execSQL(createTable);

        banco.delete("contato", null, null);

        ContentValues valores = new ContentValues();
        valores.put("nome", "Fulano");
        valores.put("telefone", "33224414");
        banco.insert("contato", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Abraoo");
        valores.put("telefone", "90748864");
        banco.insert("contato", null, valores);

        Cursor cursor = banco.query("contato", new String[] {"id", "nome", "telefone"}, null, null, null, null, "nome");

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String texto = "Contato: " + id + " - " + nome + " - " + telefone;
            Log.i("BD", texto);
        }
    }

}
