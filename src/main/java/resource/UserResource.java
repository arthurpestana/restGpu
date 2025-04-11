package resource;

import dto.UserDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.UserService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService service;
    
    @GET
    public Response findAll() {
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(long id) {
        return Response.ok().entity(service.findById(id)).build();
    }
    
    @GET
    @Path("/username/{username}")
    public Response findByNome(String username) {
        return Response.status(Response.Status.OK).entity(service.findByUsername(username)).build();
    }

    @GET
    @Path("/email/{email}")
    public Response findByEmail(String email) {
        return Response.status(Response.Status.OK).entity(service.findByEmail(email)).build();
    }

    @GET
    @Path("/telefone/{telefone}")
    public Response findByTelefone(String telefone) {
        return Response.status(Response.Status.OK).entity(service.findByTelefone(telefone)).build();
    }
    
    @POST
    public Response create(UserDTO dto) {
        return Response.status(Response.Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Long id, UserDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(Long id) {
        service.delete(id);
    }

}
