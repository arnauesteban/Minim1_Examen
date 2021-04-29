package edu.upc.dsa.models;

import java.util.Date;

public class Vacunacion {
    Usuario usuario;
    String vacuna;
    Date fecha;

    public Vacunacion(Usuario usuario, String vacuna, Date fecha)
    {
        this.usuario = usuario;
        this.vacuna = vacuna;
        this.fecha = fecha;
    }

    public Usuario getUsuario(){return usuario;}

    public String getVacuna(){return vacuna;}

    public Date getFecha(){return fecha;}
}
