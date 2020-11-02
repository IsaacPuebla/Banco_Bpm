package com.example.banco_bpm;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

import clases.Cuentas;

public class Prestamo_act extends AppCompatActivity {
    private Spinner spinCliente, spinCredito;
    private Button btnPrestamo, btnDeuda;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo_act);

        btnDeuda=(Button)findViewById(R.id.btnDeuda);
        btnPrestamo=(Button)findViewById(R.id.btnPrestamo);
        text=(TextView)findViewById(R.id.textRespuesta);
        spinCliente=(Spinner)findViewById(R.id.spin1);
        spinCredito=(Spinner)findViewById(R.id.spin2);

        String[] clientes={"CLIENTES","AXEL","ROXANA","BETSABE","MATIAS"};
        ArrayAdapter<String> spin1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,clientes);
        spinCliente.setAdapter(spin1);


        String creditos[]={"CREDITOS","HIPOTECARIO","AUTOMOTRIZ"};
        ArrayAdapter <String> spin2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,creditos);
        spinCredito.setAdapter(spin2);

    }


    public void Prestamo(View v){
        String clie=spinCliente.getSelectedItem().toString();
        String credi=spinCredito.getSelectedItem().toString();
        Cuentas cuen=new Cuentas();

        String cliente=clie.toLowerCase();
        String credito=credi.toLowerCase();

        if(cliente.equals("axel")){
            text.setText("Su saldo es: $"+cuen.getSalarioAxel());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioAxel()+cuen.getHipoteca();
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato.format(finalprestamo));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioAxel()+cuen.getAuto();
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato2.format(finalprestamo2));
                    break;
            }
        }
        else if(cliente.equals("roxana")){
            text.setText("Su saldo es: $"+cuen.getSalarioAxel());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioRoxana()+cuen.getHipoteca();
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato.format(finalprestamo));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioRoxana()+cuen.getAuto();
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato2.format(finalprestamo2));
                    break;
            }
        }
        else if(cliente.equals("betsabe")){
            text.setText("Su saldo es: $"+cuen.getSalarioBetsabe());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioBetsabe()+cuen.getHipoteca();
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato.format(finalprestamo));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioBetsabe()+cuen.getAuto();
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato2.format(finalprestamo2));
                    break;
            }
        }
        else if(cliente.equals("matias")){
            text.setText("Su saldo es: $"+cuen.getSalarioMatias());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioMatias()+cuen.getHipoteca();
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato.format(finalprestamo));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioMatias()+cuen.getAuto();
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su saldo total es: $"+formato2.format(finalprestamo2));
                    break;
            }
        }
        else{
            Toast.makeText(this,"Seleccione un cliente y un credito",Toast.LENGTH_LONG).show();
        }
    }
    public void Deuda(View v){
        String clie=spinCliente.getSelectedItem().toString();
        String credi=spinCredito.getSelectedItem().toString();
        Cuentas cuen=new Cuentas();

        String cliente=clie.toLowerCase();
        String credito=credi.toLowerCase();
        if(cliente.equals("axel")){
            text.setText("Su saldo es: $"+cuen.getSalarioAxel());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioAxel()+cuen.getHipoteca();
                    int deuda=finalprestamo/12;
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato.format(deuda));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioAxel()+cuen.getAuto();
                    int deuda2=finalprestamo2/8;
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato2.format(deuda2));
                    break;
            }
        }
        else if(cliente.equals("roxana")){
            text.setText("Su saldo es: $"+cuen.getSalarioRoxana());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioRoxana()+cuen.getHipoteca();
                    int deuda=finalprestamo/12;
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato.format(deuda));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioRoxana()+cuen.getAuto();
                    int deuda2=finalprestamo2/8;
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato2.format(deuda2));
                    break;
            }
        }
        else if(cliente.equals("betsabe")){
            text.setText("Su saldo es: $"+cuen.getSalarioBetsabe());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioBetsabe()+cuen.getHipoteca();
                    int deuda=finalprestamo/12;
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato.format(deuda));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioBetsabe()+cuen.getAuto();
                    int deuda2=finalprestamo2/8;
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato2.format(deuda2));
                    break;
            }
        }
        else if(cliente.equals("matias")){
            text.setText("Su saldo es: $"+cuen.getSalarioMatias());
            switch (credito){
                case "hipotecario":
                    int finalprestamo=cuen.getSalarioMatias()+cuen.getHipoteca();
                    int deuda=finalprestamo/12;
                    NumberFormat formato=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato.format(deuda));
                    break;
                case "automotriz":
                    int finalprestamo2=cuen.getSalarioMatias()+cuen.getAuto();
                    int deuda2=finalprestamo2/8;
                    NumberFormat formato2=NumberFormat.getIntegerInstance();
                    text.setText("Su deuda total es: $"+formato2.format(deuda2));
                    break;
            }
        }
        else{
            Toast.makeText(this,"Seleccione un cliente y un credito",Toast.LENGTH_LONG).show();
        }
    }
}