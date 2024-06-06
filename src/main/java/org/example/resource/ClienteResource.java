package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Cliente;
import org.example.repository.ClienteRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("clientes")
public class ClienteResource {

    private ClienteRepository clienteRepository = new ClienteRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente create(Cliente cliente) {
    clienteRepository.create(cliente);
    return cliente;
}

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente readById(@PathParam("id") int id) {
        return clienteRepository.readById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> readAll() {
        return clienteRepository.readAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Cliente cliente, @PathParam("id") int id) {
        clienteRepository.updateById(cliente, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        clienteRepository.deleteById(id);
    }
}
