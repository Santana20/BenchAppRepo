package pe.upc.bench.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Pizzeria;
import pe.upc.bench.repositorios.RepositorioPizzeria;

@Service
public class ServicioPizzeria {
	
	@Autowired
	private RepositorioPizzeria repositorioPizzeria;
	
	//REGISTRAR PIZZERIA
	@Transactional(rollbackFor = Exception.class)
	public Pizzeria registrarPizzeria(Pizzeria pizzeria) throws Exception {
		if(pizzeria.getCodigo()==null) {
			return repositorioPizzeria.save(pizzeria);
		}else {
			throw new Exception();
		}
	}
	
	//ACTUALIZAR DATOS DE LA PIZZERIA 
	public Pizzeria actualizarPizzeria(Pizzeria pizzeria) throws Exception {
		if(pizzeria.getCodigo()!=null) {
			return repositorioPizzeria.saveAndFlush(pizzeria);
		}else {
			throw new Exception();
		}
	}
	
	
	
	//OBTENER DATOS DE LA PIZZERIA
	public Pizzeria obtenerPizzeria(Long codigo) throws Exception {
		Pizzeria p;
		p=repositorioPizzeria.obtenerPizzeria(codigo);
		if(p==null) throw new Exception("entidad no encontrada");
		return p;
	}
}
