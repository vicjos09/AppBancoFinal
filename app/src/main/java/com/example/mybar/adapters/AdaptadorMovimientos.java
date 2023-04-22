package com.example.mybar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Movimientos;
import com.example.mybar.R;

import java.util.ArrayList;

public class AdaptadorMovimientos extends ArrayAdapter<Movimientos> {

    AppCompatActivity appCompatActivity;

    private ArrayList<Movimientos> listaMovimientos;

    public AdaptadorMovimientos(AppCompatActivity context, ArrayList<Movimientos> listaMov){
        //Copiar Platos
        super(context, R.layout.movimientos_avtivity, listaMov);
        listaMovimientos=listaMov;
        appCompatActivity = context;

    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.movimiento, null);

        ImageView imageView1 = item.findViewById(R.id.dinero);
        imageView1.setImageResource(R.mipmap.monedas);

        TextView textView1 = item.findViewById(R.id.tipo);
        textView1.setText( listaMovimientos.get(position).getFecha());

        TextView textView2 = item.findViewById(R.id.montoMovimientos);
        textView2.setText( listaMovimientos.get(position).getMonto());

        return(item);

    }


}
