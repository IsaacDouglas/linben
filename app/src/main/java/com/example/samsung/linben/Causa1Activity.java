package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raquel on 12/05/2016.
 */
public class Causa1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causa1);
        Button bt_apoiar = (Button) findViewById(R.id.bt_apoiar);
        Button bt_doar = (Button) findViewById(R.id.bt_doar);
        Button bt_voltar = (Button) findViewById(R.id.voltar);




        bt_voltar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(Causa1Activity.this, InicioActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

    }
}
