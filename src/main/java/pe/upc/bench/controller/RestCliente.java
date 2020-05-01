package pe.upc.bench.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.servicios.ServicioCliente;

@RestController
@RequestMapping("/api")
public class RestCliente {

	@Autowired
	private ServicioCliente serviciocliente;
	
	//REGISTRAR UN CLIENTE
	@PostMapping("/cliente")
	public Cliente registrarcliente(@RequestBody Cliente cliente) {
		Cliente c;
		try {
			c=serviciocliente.registrarCliente(cliente);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede resgistrar");
		}
		return c;
	}
	
	//OBTENER UN CLIENTE
	@GetMapping("/cliente/{dni}")
	public Cliente obtenerCliente(@PathVariable(value = "dni") String dni) {
		Cliente c=null;
		try {
			c=serviciocliente.obtenerCliente(dni);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return c;
	}
	
	//OBTENER LISTA CLIENTES
	@GetMapping("/clientes")
	public List<Cliente> obtenerClientes(){
		return serviciocliente.obtenerClientes();
	}
	
	
	//ELIMINAR CLIENTE
	@DeleteMapping("/borrar/{dni}")
	public Cliente borrarCliente(@PathVariable(value = "dni") String dni) {
		Cliente c;
		try {
			c=serviciocliente.borrarCliente(dni);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return c;
	}
}
