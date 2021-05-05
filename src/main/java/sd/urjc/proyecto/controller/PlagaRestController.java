package sd.urjc.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.repository.PlagaRepository;
import java.util.Optional;

@RestController
@RequestMapping("/plagas")
public class PlagaRestController {
	
	@Autowired
	private PlagaRepository repPlagas;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Plaga> getPlaga(@PathVariable String id) {
		Optional<Plaga> opt= repPlagas.findById(Long.parseLong(id));
        if (opt.isPresent()) {
            return new ResponseEntity<Plaga>(opt.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Plaga>(HttpStatus.NOT_FOUND);
        }
	}
}