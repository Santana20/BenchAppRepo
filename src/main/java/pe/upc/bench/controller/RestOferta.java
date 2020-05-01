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

import pe.upc.bench.entidades.Oferta;
import pe.upc.bench.servicios.ServicioOferta;

@RestController
@RequestMapping("/api")
public class RestOferta {
	@Autowired
	private ServicioOferta serviciooferta;
	
	//REGISTRAR OFERTA
	@PostMapping("/oferta/{codigo}")
	public Oferta registrarOferta(@PathVariable(value = "codigo") Long codigo, @RequestBody Oferta oferta) {
		Oferta o;
		try {
			o=serviciooferta.registrarOferta(codigo, oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar oferta");
		}
		return o;
	}
	
	//ACTUALIZAR OFERTA
	@PostMapping("/actualizarOferta")
	public Oferta actualizarOferta(@RequestBody Oferta oferta) {
		Oferta o;
		try {
			o=serviciooferta.actualizarOferta(oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede actualizar");
		}
		return o;
	}
	
	//ELIMINAR OFERTA
	@GetMapping("/eliminarcliente/{dni}")
	public Oferta eliminarOferta(Long codigo) {
		Oferta o;
		try {
			o=serviciooferta.eliminarOferta(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return o;
	}
	
	//OBTENER OFERTA 
	@GetMapping("/oferta/{codigo}")
	public Oferta obtenerOferta(@PathVariable(value = "codigo")Long codigo) {
		Oferta o=null;
		try {
			o=serviciooferta.obtenerOferta(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return o;
	}
}
