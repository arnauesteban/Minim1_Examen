package edu.upc.dsa.models;

import java.util.Date;

public class Seguimiento {
    Date fecha;
    String descripcion;

    public Seguimiento(Date fecha, String descripcion)
    {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Date getFecha(){return fecha;}

    public String getDescripcion(){return descripcion;}
}
