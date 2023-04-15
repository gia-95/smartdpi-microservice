package it.smartdpi.utenteservice.repository;

import it.smartdpi.utenteservice.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    public Utente getUtenteById(Long idUtente);
}
