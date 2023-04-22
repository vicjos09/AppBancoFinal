package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.R;
import com.example.mybar.Usuario;

import java.util.ArrayList;

public class Creditos extends AppCompatActivity {
    ArrayList<String>   listaTipoDeMovimiento=new ArrayList<>();
    com.example.mybar.Usuario usuario;

    ArrayList<String>   listaTipoDeMonto=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditos);

        final Button btnPago = (Button)findViewById(R.id.buttonP);

        listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        listaTipoDeMonto=(ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        ImageView iv = (ImageView) findViewById(R.id.casa);
        iv.setImageResource(R.mipmap.pngegg);

        Bundle bundle = this.getIntent().getExtras();
        usuario=new Usuario(bundle.getString("Usuario"),bundle.getString("Saldo"));

        btnPago.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int operacion= Integer.parseInt(usuario.getSaldo());
                operacion=operacion-200000;
                listaTipoDeMonto.add("-"+200000);

                Intent intent = new Intent(Creditos.this, Inicio.class);

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
