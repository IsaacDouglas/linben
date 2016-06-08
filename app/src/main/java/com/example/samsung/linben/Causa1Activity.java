package com.example.samsung.linben;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Raquel on 12/05/2016.
 */
public class Causa1Activity extends Activity {
   // private RelativeLayout rl;
    //private FragmentActivity fa;
    private Button bt_apoiar;
    private Button bt_doar;
    private Button bt_voltar;

    protected void onCreate(Bundle savedInstanceState){
   // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //fa = (FragmentActivity) super.getActivity();
        //rl = (RelativeLayout) inflater.inflate(R.layout.activity_causa1, container, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causa1);
        bt_apoiar = (Button) findViewById(R.id.bt_apoiar);
        bt_doar = (Button) findViewById(R.id.bt_doar);
        bt_voltar = (Button) findViewById(R.id.voltar);




        bt_voltar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(Causa1Activity.this, InicioActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

      //  return rl;
    }
}
