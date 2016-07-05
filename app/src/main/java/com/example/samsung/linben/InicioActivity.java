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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends Activity{
    private RelativeLayout rl;
    private FragmentActivity fa;
    private Button bt_criar;
    private Button bt_ver1;

    ListaCausaActivity listaCausa = new ListaCausaActivity();

    ListView list;
    String[] itemname ={
            "Mariana",
            "Claádia",
            "Júlio",
            "Nathália",
            "Paulo",
            "Felipe"
    };

    Integer[] imgid ={
            R.drawable.fotoperfilvideo,
            R.drawable.fotohome1,
            R.drawable.fotohome2,
            R.drawable.fotohome3,
            R.drawable.fotohome4,
            R.drawable.fotohome5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
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
