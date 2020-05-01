package pe.upc.bench.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.bench.entidades.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
	@Query("SELECT c FROM Cliente c WHERE c.dni=:dni")
	Cliente buscarCliente(@Param("dni") String dni);

}
