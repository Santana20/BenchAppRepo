package pe.upc.bench.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.entidades.Pedido;
import pe.upc.bench.repositorios.RepositorioCliente;

@Service
public class ServicioCliente {
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	//OBTENER UN SOLO CLIENTE
		public Cliente obtenerCliente(String dni ) throws Exception {
			Cliente c;
			c=repositorioCliente.buscarCliente(dni);
			if(c==null) throw new Exception("entidad no encontrada");
			return c;
			
		}
		
		//REGISTRAR UN SOLO CLIENTE
		@Transactional(rollbackFor = Exception.class)
		public Cliente registrarCliente(Cliente cliente) throws Exception {
			if(cliente.getCodigo()==null) {
				return repositorioCliente.save(cliente);
			}else {
				throw new Exception();
			}
		}
		
		//OBTENER  PEDIDOS DE UN SOLO CLIENTE
		public List<Pedido> obtenerPedidosCliente(String dni) throws Exception{
			Cliente cliente=obtenerCliente(dni);
			return cliente.getPedidos();
		}
		
		
		
		//OBTENER LISTA DE CLIENTES
		public List<Cliente> obtenerClientes(){
			return repositorioCliente.findAll();
		}
		
		
		//ELIMINAR CLIENTE
		public Cliente borrarCliente(String dni) throws Exception {
			Cliente c;
			c=obtenerCliente(dni);
			if(c.getCodigo()!=null) {
				repositorioCliente.delete(c);
			}else {
				throw new Exception();
			}
			return c;
		}
}
