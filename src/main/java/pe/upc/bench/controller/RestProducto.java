package pe.upc.bench.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.bench.entidades.Producto;
import pe.upc.bench.servicios.ServicioProducto;

@RestController
@RequestMapping("/api")
public class RestProducto {

	@Autowired
	private ServicioProducto servicioproducto;
	
	//REGISTRAR PRODUCTO
	@PostMapping("/producto/{codigo}")
	public Producto registrarProducto(@PathVariable(value = "codigo") Long codigo,@RequestBody Producto producto) {
		Producto p;
		try {
			p=servicioproducto.registrarProducto(codigo, producto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar producto");
		}
		return p;
	}
	
	//ACTUALIZAR PRODUCTO
	@PostMapping("/actualizarProducto/{codigo}")
	public Producto actualizarProducto(@PathVariable(value = "codigo") Long codigo,@RequestBody Producto producto) {
		Producto p;
		try {
			p=servicioproducto.actualizarProducto(codigo, producto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar producto");
		}
		return p;
	}
	
	
	//ELIMINAR PRODUCTO
	@DeleteMapping("/eliminarProducto/{codigo}")
	public Producto eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Producto p;
		try {
			p=servicioproducto.eliminarProducto(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return p;
	}
}
