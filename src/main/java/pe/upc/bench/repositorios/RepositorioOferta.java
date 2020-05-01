package pe.upc.bench.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.bench.entidades.Oferta;

public interface RepositorioOferta extends JpaRepository<Oferta, Long>{
	
	@Query("SELECT c FROM Oferta c WHERE c.codigo=:codigo")
	Oferta buscarOferta(@Param("codigo") Long codigo);

}
