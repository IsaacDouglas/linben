package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button bt_criar = (Button) findViewById(R.id.criar);
        Button bt_ver1 = (Button) findViewById(R.id.ver1);

        bt_criar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(InicioActivity.this, ApeloActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );


        bt_ver1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(InicioActivity.this, Causa1Activity.class);
                                            startActivity(i);
                                        }
                                    }
        );


    }
}
