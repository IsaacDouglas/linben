package com.example.samsung.linben;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class VerCausaActivity extends AppCompatActivity {

    //atributo da classe.
    private AlertDialog alerta;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate( R.layout.activity_ver_causa,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alerta = builder.create();

//definimos para o botão do layout um clickListener

      //  view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {

/*
            public void onClick(View arg0) { //exibe um Toast informativo.

                //  Toast.makeText(AlertWifiActivity.this, "alerta.dismiss()", Toast.LENGTH_SHORT).show(); //desfaz o alerta.
                Intent i = new Intent(VerCausaActivity.this, MenuActivity.class);
                startActivity(i);
                //  alerta.dismiss();

            }

        });

*/
        alerta.show();

    }
}
