package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.Movimientos;
import com.example.mybar.R;
import com.example.mybar.Usuario;
import com.example.mybar.adapters.AdaptadorMovimientos;

import java.util.ArrayList;

public class VerMovimientos extends AppCompatActivity {

    private ArrayList<Movimientos> listaMov;



    com.example.mybar.Usuario usuario;

    int tama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movimientos_avtivity);
        Bundle bundle = this.getIntent().getExtras();

        ArrayList<String>   listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        ArrayList<String>   listaTipoDeMonto = (ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        listaMov = new ArrayList<Movimientos>();



        tama=listaMov.size();
        int contador=0;
        for(String tipo:listaTipoDeMovimiento){

            listaMov.add(new Movimientos(tipo,listaTipoDeMonto.get(contador)));
            contador++;

        }





        AdaptadorMovimientos adaptador = new AdaptadorMovimientos(this, listaMov);
        ListView listaDeMovimientos = findViewById(R.id.list1);
        listaDeMovimientos.setAdapter(adaptador);
        listaDeMovimientos.setAdapter(adaptador);
        ListView listaMovimientos = findViewById(R.id.list1);





        }


}
