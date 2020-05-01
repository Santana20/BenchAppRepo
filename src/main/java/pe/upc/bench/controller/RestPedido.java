package pe.upc.bench.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.bench.entidades.Pedido;
import pe.upc.bench.servicios.ServicioPedido;

@RestController
@RequestMapping("/api")
public class RestPedido {
	@Autowired
	private ServicioPedido serviciopedido;
	
	//REGISTRAR PEDIDO
	@PostMapping("/pedido/{dni}")
	public Pedido registrarPedido(@PathVariable(value = "dni") String dni, @RequestBody Pedido pedido) {
		Pedido p;
		try {
			p=serviciopedido.realizarPedido(dni, pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No es posible realizar el Pedido");
		}
		
		return p;
	}
	
	//OBTENER PEDIDO
	@GetMapping("/pedido/{codigo}")
	public Pedido obtenerPedido(@PathVariable(value = "codigo") Long codigo) {
		Pedido p=null;
		try {
			p=serviciopedido.obtenerPedido(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return p;
	}
}
