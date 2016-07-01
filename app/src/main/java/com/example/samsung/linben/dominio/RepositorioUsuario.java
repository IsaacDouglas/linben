package com.example.samsung.linben.dominio;

import android.content.Context;
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

    public ArrayList<String> buscarUsuario(Context context){

        ArrayAdapter<String> adpUsuarios = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        return null;
    }


}
