package com.example.mybar;

public class Usuario {

    private  String ID;
    private String usuario;
    private String contrasena;
    private String saldo;

    public Usuario(String usuario, String saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public Usuario(){

    }
    public Usuario(String ID, String usuario, String contrasena, String saldo) {
        this.ID = ID;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    public String getID() {
        return ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }



}
