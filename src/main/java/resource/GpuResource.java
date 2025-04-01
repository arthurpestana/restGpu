package resource;

import dto.GpuDTO;
import dto.GpuResponseDTO;
import dto.ManufacturerResponseDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.GpuService;
import java.util.List;

@Path("gpus")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GpuResource {

    @Inject
    GpuService service;

    @GET
    public List<GpuResponseDTO> findAllGpus() {
        return service.findAll();
    }

    @GET
    @Path("/nome/{nome}")
    public List<GpuResponseDTO> findByNameGpu(String nome) {
        return service.findByName(nome);
    }

    @GET
    @Path("/fabricante/{id}")
    public List<GpuResponseDTO>  buscarPorFabricante(long id) {
        return service.findByManufacturer(id);
    }

    @POST
    public GpuResponseDTO createGpu(GpuDTO dto) {
        return service.createGpu(dto);
    }

    @PUT
    @Path("/{id}")
    public void updateGpu(Long id, GpuDTO dto) {
        service.updateGpu(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteGpu(Long id) {
        service.deleteGpu(id);
    }
}
