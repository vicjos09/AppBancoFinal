package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.R;
import com.example.mybar.Usuario;

import java.util.ArrayList;

public class TarjetasDeCredito extends AppCompatActivity {

    ArrayList<String> listaTipoDeMovimiento=new ArrayList<>();

    ArrayList<String>   listaTipoDeMonto=new ArrayList<>();

    com.example.mybar.Usuario usuario;
    TextView saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarjetascredito);

        final Button btnRecargar = (Button)findViewById(R.id.pagarTdc);

        Bundle bundle = this.getIntent().getExtras();

        listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        listaTipoDeMonto=(ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        usuario=new Usuario(bundle.getString("Usuario"),bundle.getString("Saldo"));
        ImageView iv = (ImageView) findViewById(R.id.tarjeta1231);

        iv.setImageResource(R.mipmap.tarjeta);
        iv.setImageResource(R.mipmap.tarjeta);
        saldo = (TextView) findViewById(R.id.tarjeta21);
        saldo.setText("$143,000");
        btnRecargar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int operacion= Integer.parseInt(usuario.getSaldo());
                operacion=operacion-143000;
                listaTipoDeMonto.add("-"+143000);

                Intent intent = new Intent(TarjetasDeCredito.this, Inicio.class);

                intent.putExtra("Saldo",  String.valueOf(operacion));
                intent.putExtra("Usuario", usuario.getUsuario());
                intent.putStringArrayListExtra("tipo", listaTipoDeMovimiento);
                intent.putStringArrayListExtra("monto", listaTipoDeMonto);

                Bundle b = new Bundle();

                b.putString("Usuario", usuario.getUsuario());
                b.putString("Saldo",   String.valueOf(operacion));
                saldo.setText("$0");
                startActivity(intent);

            }


        });

    }










}
