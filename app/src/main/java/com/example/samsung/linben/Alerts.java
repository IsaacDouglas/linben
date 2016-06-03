package com.example.samsung.linben;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
/**
 * Created by Samsung on 03/06/2016.
 */
public class Alerts extends Activity{
    //atributo da classe.
    private AlertDialog alerta;

    public void exemplo_layout() {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.activity_alerta_wifi, null);
        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //exibe um Toast informativo.
                Toast.makeText(Alerts.this, "alerta.dismiss()", Toast.LENGTH_SHORT).show();
                //desfaz o alerta.
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acesso WiFi");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }
}

