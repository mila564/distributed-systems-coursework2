package sd.urjc.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sd.urjc.proyecto.model.Plaga;

@Service
public interface PlagaRepository extends JpaRepository<Plaga, Long>{
	Optional<Plaga> findByNombreVulgar(String nombreVulgar);
	Optional<Plaga> findByNombreCientifico(String nombreCientifico);
	Optional<Plaga> findByUrl(String url);
}
