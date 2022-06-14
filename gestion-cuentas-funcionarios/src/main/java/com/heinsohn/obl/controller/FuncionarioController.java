package com.heinsohn.obl.controller;


import com.heinsohn.obl.model.Funcionario;
import com.heinsohn.obl.services.IFuncionarioService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/api/v1/funcionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioController {


    private final IFuncionarioService funcionarioService;

    public FuncionarioController(IFuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;

    }


    @Path("/listar")
    @GET
    public Response getAllFuncionario(){

        return Response
                .ok(funcionarioService.findAll())
                .build();
    }

    @Path("/{id}")
    @GET
    public Response getFuncionario(@PathParam("id") Long id){
        return Response.ok(funcionarioService.findById(id)).build();
    }

    @Path("/nombre/{nombre}")
    @GET
    public Response getFuncionarioNombre(@PathParam("nombre") String nombre){
        return Response.ok(funcionarioService.findByName(nombre)).build();
    }


    @Path("/create")
    @POST
    public Response createFuncionario(Funcionario funcionario){
        return Response.ok(funcionarioService.create(funcionario)).build();
    }

    @Path("/update")
    @PUT
    public Response updateFuncionario(Funcionario funcionario){
        return Response.ok(funcionarioService.update(funcionario)).build();
    }

    @Path("/delete/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id){
        funcionarioService.delete(id);
        return Response.noContent().build();
    }


    @Path("/cargos")
    @GET
    public Response getCargo(){
        return Response.ok(funcionarioService.getCargo()).build();
    }

    @Path("/cargo/{id}")
    @GET
    public Response getCargo(@PathParam("id") Long id){
        return Response.ok(funcionarioService.getCargo(id)).build();
    }



}
