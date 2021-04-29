package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Marca;
import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.Vacunacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class Covid19ManagerService {

    private Covid19Manager escenario;

    public Covid19ManagerService() {
        this.escenario = Covid19ManagerImpl.getInstance();

        escenario = Covid19ManagerImpl.getInstance();
        escenario.anadirUsuario("1234", "Arnau");
        escenario.anadirUsuario("5678", "Juan");
        escenario.anadirUsuario("9876", "Pedro");

        escenario.anadirMarca("Pfizer");
        escenario.anadirMarca("AstraZeneca");
        escenario.anadirMarca("Moderna");
        escenario.anadirMarca("Janssen");


    }

    @PUT
    @ApiOperation(value = "Aplicar Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/vacunar")
    public Response vacunar(String id, String vacuna, Date fecha) {

        escenario.aplicarVacuna(id, vacuna, fecha);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Listar vacunaciones", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacunacion.class, responseContainer="List"),
    })
    @Path("/vacunaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaVacunaciones() {

        List<Vacunacion> lista = escenario.getVacunacionesOrderByVacunas();

        GenericEntity<List<Vacunacion>> entity = new GenericEntity<List<Vacunacion>>(lista) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "lista de marcas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Marca.class)
    })
    @Path("/marcas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaMarcas(@PathParam("id") String id) {

        Marca[] marcas = escenario.getVacunasOrderByAplicadas();

        GenericEntity<Marca[]> entity = new GenericEntity<Marca[]>(marcas) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @PUT
    @ApiOperation(value = "anadir seguimiento", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/seguimientos")
    public Response agregarSeguimiento(String id, Date fecha, String descripcion) {

        escenario.anadirSeguimiento(id, descripcion, fecha);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get lista de seguimiento a una persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class)
    })
    @Path("/seguimiento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerSeguimiento(@PathParam("id") String id) {

        List<Seguimiento> lista = escenario.getSeguimientos(id);

        GenericEntity<List<Seguimiento>> entity = new GenericEntity<List<Seguimiento>>(lista) {};
        return Response.status(201).entity(entity).build();
    }

}