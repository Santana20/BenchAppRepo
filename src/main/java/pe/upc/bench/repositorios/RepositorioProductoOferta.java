package pe.upc.bench.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.upc.bench.entidades.Producto_Oferta;

public interface RepositorioProductoOferta extends JpaRepository<Producto_Oferta, Long>{

}
