package com.example.samsung.linben.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

import com.example.samsung.linben.dominio.entidades.Usuario;

import java.util.ArrayList;

/**
 * Created by Raquel on 01/07/2016.
 */
public class RepositorioUsuario {

    SQLiteDatabase conn;

    public RepositorioUsuario(SQLiteDatabase conn){

        this.conn = conn;
    }
    public void inserir (Usuario usuario)
    {
        ContentValues values = new ContentValues();

        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("tipo_sanguineo", usuario.getTipo_sanguineo());
        values.put("genero", usuario.getGenero());
        values.put("data_nascimento", usuario.getData_nascimento().getDate());

        conn.insertOrThrow("USUARIO", null, values);

    }
    /*
    public void testeInserirUsuarios(){
        for(int i = 0; i<10;i++) {
            ContentValues values = new ContentValues();
            values.put("NOME", "Rachel");
            conn.insertOrThrow("USUARIO", null, values);
        }
    }
     ----  Usado pra teste
    */
    public ArrayAdapter<Usuario> buscarUsuario(Context context){

        ArrayAdapter<Usuario> adpUsuarios = new ArrayAdapter<Usuario>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("USUARIO",null,null,null,null,null,null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                Usuario usuario = new Usuario();
                usuario.setNome(cursor.getString(1));
                usuario.setEmail(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));
                usuario.setTipo_sanguineo(cursor.getString(4));
                usuario.setGenero(cursor.getString(5));

                adpUsuarios.add(usuario);


            } while (cursor.moveToNext());


        }
        return adpUsuarios;
    }


}
