package com.heinsohn.obl.clients;

import com.heinsohn.obl.model.Cargo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RegisterRestClient
@Path("/segip")
@Produces(MediaType.APPLICATION_JSON)
public interface EstructuraGestionClient {

    @Path("/cargos")
    @GET
    List<Cargo> listarCargos();


    @Path("/cargos/{id}")
    @GET
    Cargo listarCargos(@PathParam("id") Long id);

}
