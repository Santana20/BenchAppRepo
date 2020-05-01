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

import pe.upc.bench.entidades.Pizzeria;
import pe.upc.bench.servicios.ServicioPizzeria;

@RestController
@RequestMapping("/api")
public class RestPizzeria {
	@Autowired
	private ServicioPizzeria serviciopizzeria;
	
	//REGISTRAR PIZZERIA 
	@PostMapping("/pizzeria")
	public Pizzeria registrarPizzeria(@RequestBody Pizzeria pizzeria) {
		Pizzeria p;
		try {
			p=serviciopizzeria.registrarPizzeria(pizzeria);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//ACTUALIZAR DATOS DE LA PIZZERIA
	@PostMapping("/actualizarPizzeria")
	public Pizzeria actualizarPizzeria(@RequestBody Pizzeria pizzeria) {
		Pizzeria p;
		try {
			p=serviciopizzeria.actualizarPizzeria(pizzeria);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	
	//OBTENER DATOS DE LA PIZZERIA
	@GetMapping("/pizzeria/{codigo}")
	public Pizzeria obtenerPizzeria(@PathVariable(value = "codigo") Long codigo) {
		Pizzeria p=null;
		try {
			p=serviciopizzeria.obtenerPizzeria(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return p;
	}
}
