package clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context,@Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    @Override //Aqui definimos confiracion inicial de la bbdd
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cliente (codigo int primary key, nombre text, salario int)");
    }

    @Override //Aqui implementamos los cambios en la bbdd
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}