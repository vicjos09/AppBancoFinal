package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.R;
import com.example.mybar.Usuario;

import java.util.ArrayList;


public class Transferir extends AppCompatActivity {
    ArrayList<String>   listaTipoDeMovimiento=new ArrayList<>();
    ArrayList<String>   listaTipoDeMonto=new ArrayList<>();
    com.example.mybar.Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("DATABASE____________________Data_____________", "Data1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);

        listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        listaTipoDeMonto=(ArrayList<String>) getIntent().getStringArrayListExtra("monto");


        final Button btnTransfer = (Button)findViewById(R.id.trans);

        Bundle bundle = this.getIntent().getExtras();

        usuario=new Usuario(bundle.getString("Usuario"),bundle.getString("Saldo"));

        //Implemento el evento click de Boton Recargas
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText montoLeido = (EditText) findViewById(R.id.montoT);
                String monto=montoLeido.getText().toString();
                int operacion= Integer.parseInt(usuario.getSaldo());
                operacion=operacion-Integer.parseInt(monto);
                listaTipoDeMonto.add("-"+Integer.parseInt(monto));


                Intent intent = new Intent(Transferir.this, Inicio.class);

                intent.putExtra("Saldo",  String.valueOf(operacion));
                intent.putExtra("Usuario", usuario.getUsuario());
                intent.putStringArrayListExtra("tipo", listaTipoDeMovimiento);
                intent.putStringArrayListExtra("monto", listaTipoDeMonto);

                Bundle b = new Bundle();

                b.putString("Usuario", usuario.getUsuario());
                b.putString("Saldo",   String.valueOf(operacion));

                startActivity(intent);

            }

        });

    }
}
