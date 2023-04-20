package it.smartdpi.utenteservice.repository;

import it.smartdpi.utenteservice.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {

    Ruolo getRuoloById(Long id);
}
