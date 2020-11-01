package com.example.banco_bpm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {
    private EditText text, text1;
    private ProgressBar pb;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editNombre);
        text1 = (EditText) findViewById(R.id.editPassword);
        pb=(ProgressBar)findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);
        btn=(Button)findViewById(R.id.buttonIngresar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });

    }
    class Task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i=1;i<=10;i++){
                try{
                    Thread.sleep(250);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            String nombre=text.getText().toString().toLowerCase();
            String pass=text1.getText().toString().toLowerCase();
            if(nombre.equals("android") && pass.equals("123")){
                Intent i= new Intent(getBaseContext(), Home_Act.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Bienvenido  " + nombre,Toast.LENGTH_LONG).show();
                text.setText("");
                text1.setText("");
            }
            else{
                Toast.makeText(getApplicationContext(),"El nombre o password son erroneos",Toast.LENGTH_LONG).show();
                text.setText("");
                text1.setText("");
            }
        }
    }
    }