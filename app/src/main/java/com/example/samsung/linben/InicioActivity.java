package com.example.samsung.linben;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends Activity{
    private RelativeLayout rl;
    private FragmentActivity fa;
    private Button bt_criar;
    private Button bt_ver1;
/*
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fa = (FragmentActivity) super.getActivity();
        rl = (RelativeLayout) inflater.inflate(R.layout.activity_inicio, container, false);
        super.onCreate(savedInstanceState);
        bt_criar = (Button) rl.findViewById(R.id.criar);
        bt_ver1 =  (Button)  rl.findViewById(R.id.ver1);

        bt_criar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(fa,ApeloActivity.class);
                                            startActivity(i);
                                        }
                                    }
        );


        bt_ver1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(fa,Causa1Activity.class);
                                           startActivity(i);
                                       }
                                   }
        );
        return rl;
    }
*/

/*   protected void onCreate(Bundle savedInstanceState) {
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


    }*/
}
