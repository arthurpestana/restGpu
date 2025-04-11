package resource;

import java.util.List;

import dto.FabricanteDTO;
import dto.FabricanteResponseDTO;
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
import service.FabricanteService;

@Path("fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {
    @Inject
    FabricanteService service;

    @GET
    @Path("{id}")
    public FabricanteResponseDTO findById(long id) {
        return service.findById(id);
    }

    @GET
    public List<FabricanteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/nome/{nome}")
    public List<FabricanteResponseDTO> findByNome(String nome) {
        return service.findByNome(nome);
    }

    @POST
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void update(Long id, FabricanteDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        service.delete(id);
    }
}
