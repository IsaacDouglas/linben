package com.example.samsung.linben;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class VerCausaActivity extends AppCompatActivity {

    //atributo da classe.
    private AlertDialog alerta;
    private VideoView video;
    private File videosDir;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate( R.layout.activity_ver_causa,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alerta = builder.create();

        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r13---sn-q4f7sner.googlevideo.com/Cj0LENy73wIaNAkISL5O5YIWlhMYDSANFC241n9XMOCoAUIASARgteGy1JOTm7xXigELbU13ZDltRU1NaDAM/287B2B5239DE3C87F596ACB9E2F838E84B8A553B.5C7E2ECF9D46FC3C476B6F22F912AED2CEAF55DD/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

//definimos para o botão do layout um clickListener

      //  view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {

/*
            public void onClick(View arg0) { //exibe um Toast informativo.

                //  Toast.makeText(AlertWifiActivity.this, "alerta.dismiss()", Toast.LENGTH_SHORT).show(); //desfaz o alerta.
                Intent i = new Intent(VerCausaActivity.this, MenuActivity.class);
                startActivity(i);
                //  alerta.dismiss();

            }

        });

*/
        alerta.show();

    }
}
