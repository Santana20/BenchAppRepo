package pe.upc.bench.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.entidades.Review;
import pe.upc.bench.repositorios.RepositorioCliente;
import pe.upc.bench.repositorios.RepositorioReview;

@Service
public class ServicioReview {
	@Autowired
	private RepositorioReview repositorioreview;
	
	@Autowired
	private RepositorioCliente repositoriocliente;
	
	public Review registrarReview(Review review, Long codigoC) throws Exception{
		Cliente c = repositoriocliente.findById(codigoC).orElseThrow(()->new Exception("No existe este cliente."));
		review.setCliente(c);
		return repositorioreview.save(review);
	}
	
	public Review actualizarReview(Review review, Long codC,Long codigo)throws Exception {
		Cliente c;
		c = repositoriocliente.findById(codC).orElseThrow(()->new Exception("No existe este cliente."));
		Review r = repositorioreview.findById(codigo).orElseThrow(()->new Exception("No se puede actualizar"));
		r.setDescripcion(review.getDescripcion());
		r.setTitulo(review.getTitulo());
		return repositorioreview.save(r);
	}
	
	public Review eliminarReview(Long codC,Long codigo) throws Exception {
		Review r;
		Cliente c;
		c = repositoriocliente.findById(codC).orElseThrow(()->new Exception("No existe este cliente."));
		r = repositorioreview.findById(codigo).orElseThrow(()->new Exception("No existe la review"));
		repositorioreview.delete(r);
		return r;
	}
	
	public List<Review> obtenerReview(){
		return repositorioreview.findAll();
	}
}
