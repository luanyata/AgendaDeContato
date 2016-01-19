package com.yata.agendadecontato.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.yata.agendadecontato.dominio.Entidades.Contato;

import java.util.Date;

/**
 * Created by luan on 13/01/16.
 */
public class RepositorioContato {
    private SQLiteDatabase conn;

    public void inserir(Contato contato) {

        ContentValues values = new ContentValues();

        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("TIPOTELEFONE", contato.getTipoTelefone());
        values.put("EMAIL", contato.getEmail());
        values.put("TIPOEMAIL", contato.getTipoEmail());
        values.put("ENDERECO", contato.getEndereco());
        values.put("TIPOENDERECO", contato.getTipoEndereco());
        values.put("DATASESPECIAIS", contato.getDataEspecial().getTime());
        values.put("TIPODATASESPECIAIS", contato.getTipoDataEspecial());
        values.put("GRUPOS", contato.getGrupo());

        conn.insertOrThrow("CONTATO", null, values);
    }

    public RepositorioContato(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public ArrayAdapter<Contato> BuscaContatos(Context context) {
        ArrayAdapter<Contato> adpContato = new ArrayAdapter<Contato>(context, android.R.layout.simple_list_item_1);
        ///Cursor Responsavel por armazenar os registros da consulta
        Cursor cursor = conn.query("CONTATO", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {

                Contato contato = new Contato();
                contato.setNome(cursor.getString(1));
                contato.setTelefone(cursor.getString(2));
                contato.setTipoTelefone(cursor.getString(3));
                contato.setEmail(cursor.getString(4));
                contato.setTipoEmail(cursor.getString(5));
                contato.setEndereco(cursor.getString(6));
                contato.setTipoEndereco(cursor.getString(7));
                contato.setDataEspecial(new Date(cursor.getLong(8)));
                contato.setTipoDataEspecial(cursor.getString(9));
                contato.setGrupo(cursor.getString(10));
                adpContato.add(contato);

            } while (cursor.moveToNext());
        }
        return adpContato;
    }

}
