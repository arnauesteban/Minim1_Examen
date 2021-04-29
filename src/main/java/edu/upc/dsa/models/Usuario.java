package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

    String id;
    String nombre;
    List<Seguimiento> seguimientos;

    public Usuario(String id, String nombre) {
        this.nombre = nombre;
        this.id = id;
        this.seguimientos = new ArrayList<Seguimiento>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){this.nombre = nombre;}


    public List<Seguimiento> getListaSeguimientos(){return seguimientos;}

    public void anadirSeguimiento(Seguimiento seguimiento){this.seguimientos.add(seguimiento);}


}