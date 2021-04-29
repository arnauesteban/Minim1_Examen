package edu.upc.dsa;

import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Usuario;

import java.util.*;

import edu.upc.dsa.models.Marca;
import edu.upc.dsa.models.Vacunacion;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {
    private static Covid19Manager instance;
    protected HashMap<String, Usuario> usuarios;
    protected List<Vacunacion> vacunaciones;
    protected Marca[] marcas;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl() {
        this.usuarios = new HashMap<>();
        this.vacunaciones = new LinkedList<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    public void clearInstance()
    {
        instance = null;
    }

    @Override
    public void aplicarVacuna(String id, String vacuna, Date fecha) {
        logger.info("Vacuna aplicada: " + vacuna);
        Vacunacion vacunacion = new Vacunacion(usuarios.get(id), vacuna, fecha);
        this.vacunaciones.add(vacunacion);

        boolean encontrado = false;
        int i = 0;
        while(i < this.marcas.length && !encontrado)
        {
            if(this.marcas[i].getNombre().equals(vacuna))
            {
                encontrado = true;
                this.marcas[i].sumarVacunacion();
            }
        }

    }

    @Override
    public List<Vacunacion> getVacunacionesOrderByVacunas() {
        return null;
    }

    @Override
    public Marca[] getVacunasOrderByAplicadas() {
        Arrays.sort(this.marcas);
        return this.marcas;
    }

    @Override
    public void anadirSeguimiento(String id, String estado, Date fecha) {
        Seguimiento seguimiento = new Seguimiento(fecha, estado);
        usuarios.get(id).anadirSeguimiento(seguimiento);
    }

    @Override
    public List<Seguimiento> getSeguimientos(String id) {
        return usuarios.get(id).getListaSeguimientos();
    }

    @Override
    public void anadirUsuario(String id, String nombre)
    {
        this.usuarios.put(id, new Usuario(id, nombre));
    }

    @Override
    public void anadirMarca(String nombre) {
        marcas[marcas.length] = new Marca(nombre);
    }
}