package com.example.samsung.linben;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity  {

       @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_login);
          Button bt_nao_cadastro = (Button) findViewById(R.id.bt_novo_usuario);
           Button bt_entrar = (Button) findViewById(R.id.continuar);

          bt_nao_cadastro.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
                                                 startActivity(i);
                                             }
                                         }
          );

           bt_entrar.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      Intent i = new Intent(LoginActivity.this, InicioActivity.class);
                                                      startActivity(i);
                                                  }
                                              }
           );


      }






}



