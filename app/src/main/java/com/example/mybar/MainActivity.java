package com.example.mybar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.db.Data;
import com.example.mybar.db.DbHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> listaTipoDeMovimiento= new ArrayList<>();
    ArrayList<String> listaMonto= new ArrayList<>();
    String contraseñaActual;
    String usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.mipmap.icon_user);

        final DbHelper dbHelper=new DbHelper(MainActivity.this);
        SQLiteDatabase es= dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(es,1,2);

        dbHelper.insertData(new Data("1","Joseph","1234","1000000"));
        dbHelper.insertData(new Data("2","Vicente","1234","2000000"));
        dbHelper.insertData(new Data("3","Eber","1234","3000000"));

        Button button = (Button) findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              //  Log.i("DATABASE____________________Encontrado: "+user.getUsuario() +" Saldo:_____________"+user.getSaldo(), "Data1");
                EditText supuestaUsuario = (EditText) findViewById(R.id.edtUsuario);
                EditText supuestaContra = (EditText) findViewById(R.id.edtPassword);

                contraseñaActual=supuestaContra.getText().toString();
                usuarioActual=supuestaUsuario.getText().toString();

                Usuario user= dbHelper.searchUsr(usuarioActual);
                
                Log.i("Valor supuestacontraseña: "+supuestaContra.getText().toString()+"  contraseña "+ user.getContrasena(), "");
                Log.i("Valor supuestousuario: "+supuestaUsuario.getText().toString()+ "  usuario: "+    user.getUsuario()   ,"" );

                if (user.getUsuario() !=null) {
                    if (
                            user.getContrasena().compareTo(contraseñaActual) == 0 &&
                                    user.getUsuario().compareTo(usuarioActual) == 0) {

                        listaTipoDeMovimiento.add(" Consulta");
                        listaMonto.add(" ");


                        Log.i("DATABASE____________________Correcto Usuario: ", "");

                        Intent intent = new Intent(MainActivity.this, Inicio.class);
                        intent.putExtra("Usuario", user.getUsuario());
                        intent.putExtra("Contraseña", user.getContrasena());
                        intent.putExtra("Saldo", user.getSaldo());
                        intent.putExtra("ID", user.getID());
                        intent.putExtra("class", this.getClass());
                        intent.putStringArrayListExtra("tipo", listaTipoDeMovimiento);
                        intent.putStringArrayListExtra("monto", listaMonto);

                        Bundle b = new Bundle();
                        b.putString("Usuario", user.getUsuario());
                        b.putString("Contraseña", user.getContrasena());
                        b.putString("Saldo", user.getSaldo());
                        b.putInt("ID", Integer.valueOf(user.getID()));

                        intent.putExtras(b);
                        startActivity(intent);

                    }
                }
            }
        });

    }
}