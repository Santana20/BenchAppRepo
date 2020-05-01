package pe.upc.bench.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Oferta;
import pe.upc.bench.entidades.Pizzeria;
import pe.upc.bench.repositorios.RepositorioOferta;

@Service
public class ServicioOferta {
	@Autowired
	private RepositorioOferta repositorioOferta;
	
	@Autowired
	private ServicioPizzeria serviciopizzeria;
	
	//REGISTRAR UNA OFERTA 
	@Transactional(rollbackFor = Exception.class)
	public Oferta registrarOferta(Long codigo,Oferta oferta) throws Exception {
		Pizzeria pizzeria=serviciopizzeria.obtenerPizzeria(codigo);
		oferta.setPizzeria(pizzeria);
		return repositorioOferta.save(oferta);
	}
	
	
	//ACTUALIZAR UNA OFERTA
	public Oferta actualizarOferta(Oferta oferta) throws Exception {

		if(oferta.getCodigo()!=null) {
			return repositorioOferta.saveAndFlush(oferta);
		}else {
			throw new Exception();
		}
		
	}
	
	//OBTENER OFERTA
	public Oferta obtenerOferta(Long codigo) throws Exception {
		Oferta o;
		o=repositorioOferta.buscarOferta(codigo);
		if(o==null) throw new Exception("entidad no encontrada");
		return o;
	}
	
	
	
	//ELIMINAR UNA OFERTA
	public Oferta eliminarOferta(Long  codigo) throws Exception {
		Oferta o;
		o=obtenerOferta(codigo);
		if(o.getCodigo()!=null) {
			repositorioOferta.delete(o);
		}else {
			throw new Exception();
		}
		return o;
	}
}
