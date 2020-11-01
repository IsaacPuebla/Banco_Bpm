package com.example.banco_bpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Info_act extends AppCompatActivity {
    private VideoView vd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        vd=(VideoView)findViewById(R.id.videoView);
        vd.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.video);
        vd.start();//*******contiene audio*******

    }
    public void Mapa(View v){
        Intent i=new Intent(this,Maps_act.class);
        startActivity(i);
    }
}