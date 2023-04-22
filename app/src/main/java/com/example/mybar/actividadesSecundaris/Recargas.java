package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.R;
import com.example.mybar.Usuario;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Recargas extends AppCompatActivity {
    ArrayList<String> listaTipoDeMovimiento=new ArrayList<>();

    ArrayList<String>   listaTipoDeMonto=new ArrayList<>();
    com.example.mybar.Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recargas);

        final Button btnRecargar = (Button)findViewById(R.id.btnRecargar);

        Bundle bundle = this.getIntent().getExtras();

        listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        listaTipoDeMonto=(ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        usuario=new Usuario(bundle.getString("Usuario"),bundle.getString("Saldo"));

        //Implemento el evento click de Boton Recargas
        btnRecargar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton radioButton = (RadioButton) findViewById(R.id.cien);
                RadioButton radioButtonD = (RadioButton) findViewById(R.id.doscientos);

                boolean estadoCcien = radioButton.isChecked();
                boolean estadoDos = radioButtonD.isChecked();
                int operacion= Integer.parseInt(usuario.getSaldo());

                if (estadoDos==true){
                    operacion=operacion-200;
                    listaTipoDeMonto.add("-200");
                } else if (estadoCcien=true) {
                    operacion=operacion-100;
                    listaTipoDeMonto.add("-100");
                }

                Intent intent = new Intent(Recargas.this, Inicio.class);

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
