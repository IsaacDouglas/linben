package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by Raquel on 06/07/2016.
 */
public class AgendarActivity extends AppCompatActivity {
    private int ano, mes, dia;
    Button data;

    private Button btn_agendar;
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        btn_agendar = (Button) findViewById(R.id.agendar);
        btn_voltar = (Button) findViewById(R.id.voltarseta);

        Calendar calendar = Calendar.getInstance();
        this.ano = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH);
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
        this.data = (Button) findViewById(R.id.data);

        btn_agendar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(AgendarActivity.this, DoacaoRegistradaActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(AgendarActivity.this, InicioActivity.class);
                                               startActivity(i);
                                           }
                                       }
        );

    }

    public void selecionarData(View view){
        showDialog(view.getId());
    }


}
