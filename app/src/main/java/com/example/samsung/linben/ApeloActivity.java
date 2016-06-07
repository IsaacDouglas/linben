package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

/**
 * Created by Raquel on 12/05/2016.
 */
public class ApeloActivity extends Fragment {
    private Spinner estado;
    private Spinner cidade;
    private Spinner categoria;
    private Spinner hemocentro;
    private RelativeLayout rl;
    private FragmentActivity fa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fa = (FragmentActivity) super.getActivity();
        rl = (RelativeLayout) inflater.inflate(R.layout.activity_apelo, container, false);
        super.onCreate(savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                fa, R.array.estado,
                android.R.layout.simple_spinner_item);
        estado = (Spinner) rl.findViewById(R.id.estado);
        estado.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                fa, R.array.cidade,
                android.R.layout.simple_spinner_item);
        cidade = (Spinner) rl.findViewById(R.id.cidade);
        cidade.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                fa, R.array.categoria,
                android.R.layout.simple_spinner_item);
        categoria = (Spinner) rl.findViewById(R.id.categoria);
        categoria.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                fa, R.array.hemocentro,
                android.R.layout.simple_spinner_item);
        hemocentro = (Spinner) rl.findViewById(R.id.hemocentro);
        hemocentro.setAdapter(adapter3);

        return rl;
    }
}
