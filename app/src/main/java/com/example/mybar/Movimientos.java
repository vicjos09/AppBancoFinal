package com.example.mybar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimientos {
    String fecha;
    String monto;

    String tipo;



    public Movimientos(String fecha, String monto) {
        this.fecha = fecha;
        this.monto = monto;


    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMonto() {
        return monto;
    }
}
