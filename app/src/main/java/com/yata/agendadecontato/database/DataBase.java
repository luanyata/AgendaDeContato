package com.yata.agendadecontato.database;

/**
 * Created by luan on 12/01/16.
 */

import android.content.Context;
import android.database.sqlite.*;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "AGENDA", null, 1);
    }

    //Responsavel pela criação da tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSQL.getCreateContato());
    }

    //Responsavel pela atalização das tabelas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
