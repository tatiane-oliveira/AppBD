package com.example.iossenac.appbd.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iossenac on 20/05/17.
 */

public class Banco extends SQLiteOpenHelper {

    private static String nomeBd = "crudContato.db";

    private static String createTable = "CREATE TABLE contato" +
                                        "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "nome VARCHAR(30)," +
                                        "telefone VARCHAR(10));";

    public Banco(Context context) {
        super(context, nomeBd, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contato");
        db.execSQL(createTable);
    }
}
