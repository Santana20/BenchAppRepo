package pe.upc.bench.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.upc.bench.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long>{

	@Query("SELECT c FROM Pedido c WHERE c.codigo=:codigo")
	Pedido buscarPedido(@Param("codigo") Long codigo);
}
