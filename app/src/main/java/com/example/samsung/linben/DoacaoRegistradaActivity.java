package com.example.samsung.linben;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class DoacaoRegistradaActivity extends AppCompatActivity {

    private AlertDialog alerta;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate( R.layout.activity_doacao_registrada,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alerta = builder.create();

//definimos para o botão do layout um clickListener

       view.findViewById(R.id.fechar).setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) { //exibe um Toast informativo.

               // Toast.makeText(DoacaoRegistradaActivity.this, "alerta.dismiss()", Toast.LENGTH_SHORT).show(); //desfaz o alerta.
                Intent i = new Intent(DoacaoRegistradaActivity.this, AgendarActivity.class);
                startActivity(i);
             //   alerta.dismiss();

            }

        });

        alerta.show();


    }
}
