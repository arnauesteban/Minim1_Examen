package edu.upc.dsa;

import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.Marca;
import edu.upc.dsa.models.Vacunacion;

import java.util.Date;
import java.util.List;

public interface Covid19Manager {

    public void aplicarVacuna(String id, String vacuna, Date fecha);
    public List<Vacunacion> getVacunacionesOrderByVacunas();
    public Marca[] getVacunasOrderByAplicadas();
    public void anadirSeguimiento(String id, String estado, Date fecha);
    public List<Seguimiento> getSeguimientos(String id);

    public void anadirUsuario(String id, String nombre);
    public void anadirMarca(String nombre);
    public void clearInstance();
}
