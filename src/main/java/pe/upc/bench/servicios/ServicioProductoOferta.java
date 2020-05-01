package pe.upc.bench.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Oferta;
import pe.upc.bench.entidades.Producto;
import pe.upc.bench.entidades.Producto_Oferta;
import pe.upc.bench.repositorios.RepositorioProductoOferta;

@Service
public class ServicioProductoOferta {
	@Autowired
	private RepositorioProductoOferta repositorioProductoOferta;
	
	@Autowired
	private ServicioProducto servicioproducto;
	
	@Autowired
	private ServicioOferta serviciooferta;
	
	//REGISTRAR PRODUCTO OFERTA
	@Transactional(rollbackFor = Exception.class)
	public Producto_Oferta registrarProductoOferta(Long codigo, Long codigo2, Producto_Oferta producto_Oferta) throws Exception {
		Producto producto=servicioproducto.obtenerProducto(codigo);
		producto_Oferta.setProducto(producto);
		Oferta oferta=serviciooferta.obtenerOferta(codigo2);
		producto_Oferta.setOferta(oferta);
		return repositorioProductoOferta.save(producto_Oferta);
	}
}
