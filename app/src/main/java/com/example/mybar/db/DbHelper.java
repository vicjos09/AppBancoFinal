package com.example.mybar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mybar.Usuario;


public class DbHelper extends SQLiteOpenHelper {


    private static  int DATABASE_VERSION=1;
    private static final String DATABASE_Nombre="usuario4.db";
    public static final String TABLE_CA="usuarios";

    public DbHelper(@Nullable Context context ) {
        super(context, DATABASE_Nombre, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CA + "(" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                               "Usuario TEXT NOT NULL,"+
                               "Contrasena TEXT NOT NULL,"+
                               "Saldo TEXT NOT NULL)"
                                );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CA );
        onCreate(sqLiteDatabase);
    }

    public void insertData(Data data){
         SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
          ContentValues contentValues= new ContentValues(0);
          contentValues.put("ID",data.getID());
          contentValues.put("Usuario",data.getUsuario());
          contentValues.put("Contrasena",data.getContrasena());
          contentValues.put("Saldo",data.getSaldo());

          sqLiteDatabase.insert(TABLE_CA , null,contentValues);
          Log.i("DATABASE____________________Data_____________", "Data1");

    }
    public Usuario searchUsr(String name){
        Usuario user2Serch=new Usuario();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c= db.rawQuery("SELECT * FROM "+ TABLE_CA + " WHERE Usuario =?", new String[]{name});

        if (c.moveToLast()){
            user2Serch.setID(c.getString(0));
            user2Serch.setUsuario(c.getString(1));
            user2Serch.setContrasena(c.getString(2));
            user2Serch.setSaldo(c.getString(3));
            Log.i("DATABASE____________________Encontrado Contraseña:_____________"+c.getString(2), "Data1");

        }else {
            Log.e("Error not fund","user can't be found or data base empty");

        }
        return user2Serch;
    }

}
