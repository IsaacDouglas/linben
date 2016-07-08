package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raquel on 08/07/2016.
 */
public class CadastroGotinhaActivity extends AppCompatActivity {

    private Button btn_voltar;
    private Button btn_concluir;
    private Button btn_ajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_gotinha);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_concluir = (Button) findViewById(R.id.concluir);
        btn_ajuda = (Button) findViewById(R.id.ajuda);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroGotinhaActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroGotinhaActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroGotinhaActivity.this, AjudaActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

    }
}
