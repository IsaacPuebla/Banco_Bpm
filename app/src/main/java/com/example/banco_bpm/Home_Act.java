package com.example.banco_bpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Home_Act extends AppCompatActivity {
    private ViewFlipper vf;
    private int image[]={R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        vf=(ViewFlipper)findViewById(R.id.slider);
        for(int i=0;i<image.length;i++){
            flip_image(image[i]);
        }

    }
    public void flip_image(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(1800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }
    public void Cliente(View v){
        Intent i=new Intent(this,Clientes_act.class);
        startActivity(i);
    }
    public void Prestamo(View v){
        Intent i=new Intent(this,Prestamo_act.class);
        startActivity(i);
    }
    public void Seguridad(View v){
        Intent i=new Intent(this,Seguridad_act.class);
        startActivity(i);
    }
    public void Informacion(View v){
        Intent i=new Intent(this,Info_act.class);
        startActivity(i);
    }
}