package com.example.samsung.linben.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Raquel on 01/07/2016.
 */
public class RepositorioUsuario {

    SQLiteDatabase conn;

    public RepositorioUsuario(SQLiteDatabase conn){

        this.conn = conn;
    }
    public void testeInserirUsuarios(){
        for(int i = 0; i<10;i++) {
            ContentValues values = new ContentValues();
            values.put("NOME", "Rachel");
            conn.insertOrThrow("USUARIO", null, values);
        }
    }
    public ArrayAdapter<String> buscarUsuario(Context context){

        ArrayAdapter<String> adpUsuarios = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("USUARIO",null,null,null,null,null,null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                String nome = cursor.getString(1);
                adpUsuarios.add(nome);

            } while (cursor.moveToNext());


        }
        return adpUsuarios;
    }


}
