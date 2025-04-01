package resource;

import dto.ManufacturerDTO;
import dto.ManufacturerResponseDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.ManufacturerService;

import java.util.List;

@Path("fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ManufacturerResource {
    @Inject
    ManufacturerService service;

    @GET
    @Path("{id}")
    public ManufacturerResponseDTO buscarUm(long id) {
        return service.findById(id);
    }

    @GET
    public List<ManufacturerResponseDTO> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/nome/{nome}")
    public List<ManufacturerResponseDTO>  buscarPorNome(String nome) {
        return service.findByNome(nome);
    }

    @POST
    public ManufacturerResponseDTO incluir(ManufacturerDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, ManufacturerDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }
}
