package edu.upc.dsa.models;

public class Marca implements Comparable<Marca> {
    String nombre;
    int numeroAplicadas;

    public Marca(String nombre)
    {
        this.nombre = nombre;
        this.numeroAplicadas = 0;
    }

    public String getNombre(){return this.nombre;}

    public int getNumeroAplicadas(){return this.numeroAplicadas;}

    public void sumarVacunacion()
    {
        this.numeroAplicadas++;
    }

    @Override
    public int compareTo(Marca o) {
        return o.getNumeroAplicadas() - this.getNumeroAplicadas();
    }
}
