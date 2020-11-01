package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText text;
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        view = (TextView) findViewById(R.id.View);
        text = (EditText) findViewById(R.id.Pass);
    }

    private SecretKeySpec generateKey(String pass) throws Exception {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = pass.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    public String Encriptar(String datos, String pass) throws Exception {
        if (!text.getText().toString().isEmpty()) {
            SecretKeySpec secretKey = generateKey(pass);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        } else {
            Toast.makeText(this, "Debe ingresar Contraseña", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void devuelta(View v) {
        try {
            String mensaje = Encriptar(text.getText().toString(), text.getText().toString());
            view.setText(mensaje);
        } catch (Exception e) {

        }
    }
}