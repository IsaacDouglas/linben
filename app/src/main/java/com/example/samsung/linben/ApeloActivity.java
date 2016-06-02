package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Raquel on 12/05/2016.
 */
public class ApeloActivity extends AppCompatActivity {
    private Spinner estado;
    private Spinner cidade;
    private Spinner categoria;
    private Spinner hemocentro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apelo);

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

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.categoria,
                android.R.layout.simple_spinner_item);
        categoria = (Spinner) findViewById(R.id.categoria);
        categoria.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.hemocentro,
                android.R.layout.simple_spinner_item);
        hemocentro = (Spinner) findViewById(R.id.hemocentro);
        hemocentro.setAdapter(adapter3);
    }
}
