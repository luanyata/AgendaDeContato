package com.yata.agendadecontato.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

/**
 * Created by luan on 13/01/16.
 */
public class RepositorioContato {
    private SQLiteDatabase conn;


    public void TesteInserirContatos(){

        for(int i = 0; i < 10; i++) {
            ContentValues values = new ContentValues();
            values.put("TELEFONE", "99999999");
            conn.insertOrThrow("CONTATO", null, values);
        }
    }

    public RepositorioContato(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public ArrayAdapter<String> BuscaContatos(Context context) {
        ArrayAdapter<String> adpContato = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        ///Cursor Responsavel por armazenar os registros da consulta
        Cursor cursor = conn.query("CONTATO", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
           cursor.moveToFirst();

            do {

                String telefone = cursor.getString(1);
                adpContato.add(telefone);

            } while (cursor.moveToNext());
        }
        return adpContato;
    }

}
