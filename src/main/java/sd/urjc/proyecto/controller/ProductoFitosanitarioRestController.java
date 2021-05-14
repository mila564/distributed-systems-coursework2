package sd.urjc.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.ProductoFitosanitario;
import sd.urjc.proyecto.repository.ProductoFitosanitarioRepository;

@RestController
@RequestMapping("/productos")
public class ProductoFitosanitarioRestController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@GetMapping("/")
    private ResponseEntity<List<ProductoFitosanitario>> getProductos() {
        return new ResponseEntity<List<ProductoFitosanitario>>(repProductos.findAll(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/{nombre}")
	public ResponseEntity<ProductoFitosanitario> getProducto(@PathVariable String nombre){
		Optional<ProductoFitosanitario> opt = repProductos.findByNombre(nombre);
		if (opt.isPresent()) {
			return new ResponseEntity<ProductoFitosanitario>(opt.get(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<ProductoFitosanitario>(HttpStatus.NOT_FOUND);
		}
	}
}
