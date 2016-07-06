package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raquel on 06/07/2016.
 */
public class HemocentroActivity extends AppCompatActivity {

    private Button btn_voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemocentro);

        btn_voltar = (Button) findViewById(R.id.voltarseta);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(HemocentroActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

    }
}
