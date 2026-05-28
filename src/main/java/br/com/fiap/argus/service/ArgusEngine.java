package br.com.fiap.argus.service;

import br.com.fiap.argus.domain.Satellite;
import br.com.fiap.argus.domain.SpaceDebris;
import br.com.fiap.argus.exception.ArgusEngineException;
import org.springframework.stereotype.Service;

@Service
public class ArgusEngine implements ArgusEngineInterface {

    @Override
    public boolean checkCollisionRisk(Satellite satellite, SpaceDebris debris) {
        try {
            // Alterado de Abs para abs (Padrão Java)
            double distance = Math.abs(satellite.getAltitude() - debris.getAltitude());
            return distance < 5.0;
        } catch (Exception ex) {
            throw new ArgusEngineException("Falha no motor de processamento orbital Argus.", ex);
        }
    }

    @Override
    public void executeAutoManeuver(Satellite satellite) {
        satellite.consumeFuel(1.5);
    }
}
