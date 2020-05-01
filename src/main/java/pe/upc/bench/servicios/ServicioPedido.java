package pe.upc.bench.servicios;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.entidades.Pedido;
import pe.upc.bench.repositorios.RepositorioCliente;
import pe.upc.bench.repositorios.RepositorioPedido;

@Service
public class ServicioPedido {
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	//REALIZAR UN PEDIDO
	@Transactional(noRollbackFor =  Exception.class)
	public Pedido realizarPedido(String dni,Pedido pedido) throws Exception {
		Cliente c = null;
		c=repositorioCliente.buscarCliente(dni);
		if(c==null) throw new Exception("entidad no encontrada");
		
		pedido.setCliente(c);
		return repositorioPedido.save(pedido);			
	}
	
	public List<Pedido> obtenerPedidos(){
		return (List<Pedido>) repositorioPedido.findAll();
	}
	
	//OBTENER PEDIDO 
	public Pedido obtenerPedido(Long codigo) throws Exception {
		Pedido p;
		p=repositorioPedido.buscarPedido(codigo);
		if (p==null)throw new Exception("pedido no encontrado");
		return p;
	}

}
