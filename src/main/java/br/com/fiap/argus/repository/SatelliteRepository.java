package br.com.fiap.argus.repository;

import br.com.fiap.argus.domain.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, UUID> {
}
