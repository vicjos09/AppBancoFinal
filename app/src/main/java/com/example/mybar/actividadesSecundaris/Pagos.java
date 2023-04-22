package com.example.mybar.actividadesSecundaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybar.Inicio;
import com.example.mybar.R;
import com.example.mybar.Usuario;

import java.util.ArrayList;

public class Pagos extends AppCompatActivity {
    ArrayList<String> listaTipoDeMovimiento=new ArrayList<>();

    ArrayList<String>   listaTipoDeMonto=new ArrayList<>();
    com.example.mybar.Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagos);

        final Button btnPago = (Button)findViewById(R.id.btnPagar);

        Bundle bundle = this.getIntent().getExtras();
        usuario=new Usuario(bundle.getString("Usuario"),bundle.getString("Saldo"));

        listaTipoDeMovimiento = (ArrayList<String>) getIntent().getStringArrayListExtra("tipo");
        listaTipoDeMonto=(ArrayList<String>) getIntent().getStringArrayListExtra("monto");

        btnPago.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton radioButtonCfe = (RadioButton) findViewById(R.id.cfe);
                RadioButton radioButtonSiapa = (RadioButton) findViewById(R.id.siapa);
                RadioButton radioButtonSat = (RadioButton) findViewById(R.id.sat);

                EditText montoLeido = (EditText) findViewById(R.id.monto);

                String monto=montoLeido.getText().toString();

                boolean estadoCfe = radioButtonCfe.isChecked();
                boolean estadoSiapa = radioButtonSiapa.isChecked();
                boolean estadoSat = radioButtonSat.isChecked();

                int operacion= Integer.parseInt(usuario.getSaldo());
                listaTipoDeMonto.add("-"+Integer.parseInt(monto));

                if (estadoCfe ==true){
                    operacion=operacion-Integer.parseInt(monto);
                }
                else if (estadoSiapa==true) {
                    operacion=operacion-Integer.parseInt(monto);
                }else if (estadoSat==true) {
                    operacion=operacion-Integer.parseInt(monto);
                }

                Intent intent = new Intent(Pagos.this, Inicio.class);

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
