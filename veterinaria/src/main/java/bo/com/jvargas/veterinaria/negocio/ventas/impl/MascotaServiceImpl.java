package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.Cliente;
import bo.com.jvargas.veterinaria.datos.model.HistorialClinico;
import bo.com.jvargas.veterinaria.datos.model.Mascota;
import bo.com.jvargas.veterinaria.datos.model.dto.MascotaDto;
import bo.com.jvargas.veterinaria.datos.model.sistema.enums.TipoProceso;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ClienteRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.MascotaRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.HistorialClinicoRepository;
import bo.com.jvargas.veterinaria.negocio.admusuarios.BitacoraService;
import bo.com.jvargas.veterinaria.negocio.ventas.HistorialClinicoService;
import bo.com.jvargas.veterinaria.negocio.ventas.MascotaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("MascotaService")

public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;
    private final ClienteRepository clienteRepository;
    private final HistorialClinicoRepository historialRespository;
    private final HistorialClinicoService historialService;
    private final BitacoraService bitacoraService;

    @Override
    public List<MascotaDto> lista() {
        return mascotaRepository.listar();
    }

    @Override
    @Transactional
    public void registrar(MascotaDto mascota) {
        Mascota mascota2 = new Mascota();
        mascota2.setId(mascota.getId());
        mascota2.setNombre(mascota.getNombre());
        mascota2.setSexo(mascota.getSexo());
        mascota2.setEdad(mascota.getEdad());
        mascota2.setColor(mascota.getColor());
        mascota2.setEspecie(mascota.getEspecie());
        mascota2.setRaza(mascota.getRaza());
        Cliente cliente = clienteRepository.findByCi(mascota.getCi()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        mascota2.setCiCliente(cliente);

        HistorialClinico historialNuevo = new HistorialClinico();
        HistorialClinico historialClinico = historialRespository.save(historialNuevo);

        mascota2.setIdHistorial(historialClinico);

        Mascota mascota1 = mascotaRepository.save(mascota2);

        bitacoraService.info(TipoProceso.GESTIONAR_MASCOTA, "Mascota Registrada: {}", mascota1.getId());
    }



    @Override
    public void actualizar(Long id, Mascota mascota) {
        Mascota mascotaBuscada = mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        mascotaBuscada.setNombre(mascota.getNombre());
        mascotaBuscada.setEdad(mascota.getEdad());
        mascotaBuscada.setSexo(mascota.getSexo());
        mascotaBuscada.setColor(mascota.getColor());
        mascotaBuscada.setEspecie(mascota.getEspecie());
        mascotaBuscada.setRaza(mascota.getRaza());
        mascotaRepository.save(mascotaBuscada);

        bitacoraService.info(TipoProceso.GESTIONAR_MASCOTA, "Mascota Actualizada: {}", mascotaBuscada.getId());
    }

    @Override
    public void eliminar(Long id) {
        Mascota mascotaBuscada = mascotaRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        mascotaBuscada.setDeleted(true);

        //Por si acaso
        historialService.eliminarHistorial(mascotaBuscada.getIdHistorial().getId());

        mascotaRepository.save(mascotaBuscada);

        bitacoraService.info(TipoProceso.GESTIONAR_MASCOTA, "Mascota Eliminada: {}", id);
    }
}
