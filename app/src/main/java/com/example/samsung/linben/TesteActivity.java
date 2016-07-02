package com.example.samsung.linben;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.dominio.RepositorioUsuario;

/**
 * Created by Raquel on 23/06/2016.
 */
public class TesteActivity extends ActionBarActivity {

   // private ListView listViewUsuario;
    private ArrayAdapter<String> adpUsuarios;
    private ListView listViewUsuario;
    private RepositorioUsuario repositorioUsuario;
    private DataBase database;
    private SQLiteDatabase conn;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        this.listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);
       //this.listViewUsuario.setAdapter(new UsuarioAdapter(this, new Usuario().getLista()));

        try {
            database = new DataBase(this);
            conn = database.getWritableDatabase();

            repositorioUsuario = new RepositorioUsuario(conn);
            repositorioUsuario.testeInserirUsuarios();

            adpUsuarios = repositorioUsuario.buscarUsuario(this);
            listViewUsuario.setAdapter(adpUsuarios);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso!");
            dlg.setNegativeButton("OK", null);
            dlg.show();
        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }
    }

}


