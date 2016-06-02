package com.example.samsung.linben;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;


/**
 * Created by Samsung on 28/05/2016.
 */
public class ConfPerfilActivity extends Activity{
    private Spinner estado;
    private Spinner cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confgperfil);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.estado,
                android.R.layout.simple_spinner_item);
        estado = (Spinner) findViewById(R.id.estado);
        estado.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.cidade,
                android.R.layout.simple_spinner_item);
        cidade = (Spinner) findViewById(R.id.cidade);
        cidade.setAdapter(adapter1);

        Button btn_voltar = (Button) findViewById(R.id.voltar);
        Button btn_concluir = (Button) findViewById(R.id.concluir);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(ConfPerfilActivity.this, CadastroActivity.class);
                                            startActivity(i);
                                        }
                                    }
        );


        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(ConfPerfilActivity.this, LoginActivity.class);
                                           startActivity(i);
                                       }
                                   }
        );
    }
}
