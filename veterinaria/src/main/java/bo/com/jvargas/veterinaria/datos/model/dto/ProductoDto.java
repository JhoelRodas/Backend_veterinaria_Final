package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.Categoria;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto implements Serializable {
    private Long id;
    private String nombre;
    private BigDecimal precioUnitario;
    private Short stock;
    private String descripcion;
    private Long idCategoria;
    private String nombreCategoria;

    public ProductoDto(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precioUnitario = producto.getPrecioUnitario();
        this.stock = producto.getStock();
        this.descripcion = producto.getDescripcion();
        this.idCategoria = producto.getIdCategoria() != null ? producto.getIdCategoria().getId() : null ;
        this.nombreCategoria = producto.getIdCategoria() != null ? producto.getIdCategoria().getNombre() : null;
    }

}
