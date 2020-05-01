package pe.upc.bench.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.bench.entidades.Producto_Oferta;
import pe.upc.bench.servicios.ServicioProductoOferta;

@RestController
@RequestMapping("/api")
public class RestProductoOferta {
	@Autowired
	private ServicioProductoOferta servicioproductooferta;
	
	//REGISTRAR PRODUCTO OFERTA
	@PostMapping("/RegistrarPO/{codigo}/{codigo2}")
	public Producto_Oferta registrarProductoOferta(@PathVariable(value = "codigo") Long codigo,@PathVariable(value = "codigo2") Long codigo2,@RequestBody Producto_Oferta producto_Oferta) {
		Producto_Oferta po;
		try {
			po=servicioproductooferta.registrarProductoOferta(codigo, codigo2, producto_Oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no es posible realizar pedido producto");
		}
		return po;
	}
}
