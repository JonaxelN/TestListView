package com.example.testlistview;

public class Cliente {

    public String nombreCliente;
    public int hora;
    public int duracion;

    public Cliente(String nombreCliente, int hora, int duracion) {
        this.nombreCliente = nombreCliente;
        this.hora = hora;
        this.duracion = duracion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }
}
