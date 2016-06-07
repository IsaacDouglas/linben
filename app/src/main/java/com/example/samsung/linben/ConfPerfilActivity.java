package com.example.samsung.linben;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;


/**
 * Created by Samsung on 28/05/2016.
 */
public class ConfPerfilActivity extends Fragment {
    private Spinner estado;
    private Spinner cidade;
    private RelativeLayout rl;
    private FragmentActivity fa;
    private Button btn_voltar;
    private Button btn_concluir;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fa = (FragmentActivity) super.getActivity();
        rl = (RelativeLayout) inflater.inflate(R.layout.activity_confgperfil, container, false);
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

       btn_voltar = (Button) rl.findViewById(R.id.voltar);
       btn_concluir = (Button) rl.findViewById(R.id.concluir);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(fa, CadastroActivity.class);
                                            startActivity(i);
                                        }
                                    }
        );


        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(fa, LoginActivity.class);
                                           startActivity(i);
                                       }
                                   }
        );
        return rl;
    }
}
