package com.example.banco_bpm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {
    private Button btnGuardar,btnMostrar,btnEliminar,btnActualizar;
    private EditText tCodigo, tNombre, tSalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        btnGuardar=(Button)findViewById(R.id.btnGuardar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnActualizar=(Button)findViewById(R.id.btnActualizar);
        tCodigo=(EditText)findViewById(R.id.editCodigo);
        tNombre=(EditText)findViewById(R.id.editNombre2);
        tSalario=(EditText)findViewById(R.id.editSalario);
    }
    public void Anadir(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bbdd",null,1);
        SQLiteDatabase db =admin.getWritableDatabase();

        String codigo=tCodigo.getText().toString();
        String nombre=tNombre.getText().toString();
        String salario=tSalario.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !salario.isEmpty()){
            ContentValues cont =new ContentValues();

            cont.put("codigo",tCodigo.getText().toString());
            cont.put("nombre",tNombre.getText().toString());
            cont.put("salario",tSalario.getText().toString());

            db.insert("cliente", null,cont);
            db.close();
            Toast.makeText(this,"Has guardado un cliente",Toast.LENGTH_LONG).show();
            tCodigo.setText("");
            tNombre.setText("");
            tSalario.setText("");
        }
        else{
            Toast.makeText(this,"Todos los campos deben estar llenos.", Toast.LENGTH_LONG).show();
        }
    }
    public void Motrar(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"bbdd",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String codigo=tCodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila=db.rawQuery("SELECT codigo,nombre,salario FROM cliente WHERE codigo="+codigo,null);
            if(fila.moveToFirst()){
                tCodigo.setText(fila.getString(0));
                tNombre.setText(fila.getString(1));
                tSalario.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"Solo se puede mostrar a travez del codigo del cliente",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"No existe cliente asociado al codigo",Toast.LENGTH_LONG).show();
        }
    }
    public void Eliminar(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"bbdd",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String codigo=tCodigo.getText().toString();
        if(!codigo.isEmpty()){
            db.delete("cliente","codigo="+codigo,null);
            db.close();

            Toast.makeText(this,"Has eliminado un cliente",Toast.LENGTH_LONG).show();
            tCodigo.setText("");
            tNombre.setText("");
            tSalario.setText("");
        }
        else{
            Toast.makeText(this,"Solo se puede eliminar un cliente a traves de su codigo",Toast.LENGTH_LONG).show();
        }
    }
    public void Actualizar(View v){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bbdd",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String codigo=tCodigo.getText().toString();
        String nombre=tNombre.getText().toString();
        String salario=tSalario.getText().toString();
        ;

        ContentValues cont=new ContentValues();

        cont.put("codigo",tCodigo.getText().toString());
        cont.put("nombre",tNombre.getText().toString());
        cont.put("salario",tSalario.getText().toString());


        if(!codigo.isEmpty() && !nombre.isEmpty() && !salario.isEmpty()){

            db.update("cliente",cont,"codigo="+codigo,null);
            db.close();

            Toast.makeText(this, "Has actualizado un cliente", Toast.LENGTH_SHORT).show();
            tCodigo.setText("");
            tNombre.setText("");
            tSalario.setText("");
        }
        else{
            Toast.makeText(this,"El codigo ingresado no existe o hay un campo vacio", Toast.LENGTH_LONG).show();
            tCodigo.setText("");
            tNombre.setText("");
            tSalario.setText("");
        }
    }
}