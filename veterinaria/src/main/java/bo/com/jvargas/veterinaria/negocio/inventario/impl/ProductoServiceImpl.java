package bo.com.jvargas.veterinaria.negocio.inventario.impl;

import bo.com.jvargas.veterinaria.datos.model.Categoria;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import bo.com.jvargas.veterinaria.datos.model.dto.ProductoDto;
import bo.com.jvargas.veterinaria.datos.model.sistema.enums.TipoProceso;
import bo.com.jvargas.veterinaria.datos.repository.inventario.CategoriaRepository;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.VacunaRepository;
import bo.com.jvargas.veterinaria.negocio.inventario.ProductoService;
import bo.com.jvargas.veterinaria.negocio.admusuarios.BitacoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service("ProductoService")
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final BitacoraService bitacoraService;
    private final VacunaRepository vacunaRepository;

    @Override
    public List<ProductoDto> lista() {
        return productoRepository.listar();
    }

    @Override
    @Transactional
    public void registar(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setPrecioUnitario(productoDto.getPrecioUnitario());
        producto.setCostoCompra(productoDto.getPrecioUnitario());
        producto.setCostoPromedio(productoDto.getPrecioUnitario());
        producto.setStock(productoDto.getStock());
        producto.setDescripcion(productoDto.getDescripcion());
        Optional<Categoria> categoria = categoriaRepository.findByIdAndDeletedFalse(productoDto.getIdCategoria());
        producto.setIdCategoria(categoria.orElseThrow());
        Producto productoGuardado = productoRepository.save(producto);

        //Verifica si el producto es de categoria vacuna
        Optional<Categoria> categoriaVacuna = categoriaRepository
                .findByDeletedFalseAndNombreIgnoreCase("vacuna");
        if (categoriaVacuna.isPresent()) {
            Long idCategoriaVacuna = categoriaVacuna.get().getId();
            if (producto.getIdCategoria().getId().equals(idCategoriaVacuna)) {
                Vacuna vacuna= new Vacuna();
                vacuna.setId(productoGuardado.getId());
                vacunaRepository.save(vacuna);
            }
        }

        bitacoraService.info(TipoProceso.GESTIONAR_PRODUCTO,
                "Producto Registrado correctamente : {}",producto.getNombre());
    }

    @Override
    public void actualizar(Long id, ProductoDto producto) {
        Producto productoBuscado = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoBuscado.setNombre(producto.getNombre());
        productoBuscado.setPrecioUnitario(producto.getPrecioUnitario());
        productoBuscado.setStock(producto.getStock());
        productoBuscado.setDescripcion(producto.getDescripcion());
        Categoria categoria = categoriaRepository.findById(producto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("categoria no encontrado"));
        productoBuscado.setIdCategoria(categoria);

        productoRepository.save(productoBuscado);
        bitacoraService.info(TipoProceso.GESTIONAR_PRODUCTO,
                "Producto Actualizado correctamente : {}",productoBuscado.getNombre());
    }

    @Override
    public void eliminar(Long id) {
        Producto productoBuscado = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoBuscado.setDeleted(true);
        productoRepository.save(productoBuscado);
        bitacoraService.info(TipoProceso.GESTIONAR_PRODUCTO,
                "Producto Eliminado : {}", productoBuscado.getNombre());
    }

}
