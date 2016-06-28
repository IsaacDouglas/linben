package com.example.samsung.linben;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;

/**
 * Created by Raquel on 23/06/2016.
 */
public class TesteActivity extends ActionBarActivity {

    private ListView listViewUsuario;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        this.listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);
        this.listViewUsuario.setAdapter(new UsuarioAdapter(this, new Usuario().getLista()));
    }

}


