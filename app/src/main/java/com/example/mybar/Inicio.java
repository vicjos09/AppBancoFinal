package com.example.mybar;

import android.content.Intent;
import android.os.Bundle;

import com.example.mybar.actividadesSecundaris.Recargas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {
    String saldoEstandarizado;
    String usuarioEstandarizado;


    ArrayList<String>  tipo ;
    ArrayList<String>  monto ;

    List<String> saldosL = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = this.getIntent().getExtras();

        tipo = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        monto = (ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        TextView saldo = (TextView) findViewById(R.id.textView7);
        TextView saludoUsuario= (TextView)findViewById(R.id.textView);

        saldoEstandarizado=bundle.getString("Saldo");
        usuarioEstandarizado=bundle.getString("Usuario");

        saldosL.add(saldoEstandarizado);

        saldo.setText("$"+ saldoEstandarizado);
        saludoUsuario.setText(usuarioEstandarizado);

        FloatingActionButton fab = findViewById(R.id.fab);
        Button recargas = (Button) findViewById(R.id.buttonCelular);
        Button pagos= (Button) findViewById(R.id.pagos);
        Button hipoteca = (Button) findViewById(R.id.creditos);
        Button transfer = (Button) findViewById(R.id.transfer);
        Button tarjetasCred = (Button) findViewById(R.id.buttonTdc);

        tarjetasCred.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                tipo.add("Tarjetas de Credito");

                                                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.TarjetasDeCredito.class);
                                                intent.putExtra("Saldo", saldoEstandarizado);
                                                intent.putExtra("Usuario", usuarioEstandarizado);
                                                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                                                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);

                                                Bundle b = new Bundle();

                                                b.putString("Usuario", usuarioEstandarizado);
                                                b.putString("Saldo",saldoEstandarizado);

                                                startActivity(intent);


                                            }
                                        }
        );

        transfer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tipo.add("Transferencia");
                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.Transferir.class);
                intent.putExtra("Saldo", saldoEstandarizado);
                intent.putExtra("Usuario", usuarioEstandarizado);
                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);
                Bundle b = new Bundle();
                b.putString("Usuario", usuarioEstandarizado);
                b.putString("Saldo",saldoEstandarizado);

                startActivity(intent);


            }
        });

        hipoteca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tipo.add("Hipoteca");
                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.Creditos.class);
                intent.putExtra("Saldo", saldoEstandarizado);
                intent.putExtra("Usuario", usuarioEstandarizado);
                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);
                Bundle b = new Bundle();
                b.putString("Usuario", usuarioEstandarizado);
                b.putString("Saldo",saldoEstandarizado);


                startActivity(intent);


            }
        });

        pagos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tipo.add("pagos");
                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.Pagos.class);
                intent.putExtra("Saldo", saldoEstandarizado);
                intent.putExtra("Usuario", usuarioEstandarizado);
                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);
                Bundle b = new Bundle();
                b.putString("Usuario", usuarioEstandarizado);
                b.putString("Saldo",saldoEstandarizado);
                startActivity(intent);


            }
        });
        recargas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tipo.add("recargas");
                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.Recargas.class);
                intent.putExtra("Saldo", saldoEstandarizado);
                intent.putExtra("Usuario", usuarioEstandarizado);
                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);
                Bundle b = new Bundle();
                b.putString("Usuario", usuarioEstandarizado);
                b.putString("Saldo",saldoEstandarizado);
                startActivity(intent);


            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Movimientos:
                Log.i("ActionBar", "Movimientos");;
                Intent intent = new Intent(Inicio.this, com.example.mybar.actividadesSecundaris.VerMovimientos.class);
                intent.putStringArrayListExtra("tipo", (ArrayList<String>) tipo);
                intent.putStringArrayListExtra("monto", (ArrayList<String>) monto);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
