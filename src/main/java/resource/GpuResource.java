package resource;

import java.util.List;

import dto.GpuDTO;
import dto.GpuResponseDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import service.GpuService;

@Path("gpus")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GpuResource {

    @Inject
    GpuService service;

    @GET
    public Response findAll() {
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response findByNome(String nome) {
        return Response.status(Status.OK).entity(service.findByNome(nome)).build();
    }

    @GET
    @Path("/fabricante/{id}")
    public List<GpuResponseDTO> findByFabricante(long id) {
        return service.findByFabricante(id);
    }

    @POST
    public Response create(GpuDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Long id, GpuDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        service.delete(id);
    }
}
