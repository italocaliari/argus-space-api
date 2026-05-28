package br.com.fiap.argus.service;

import br.com.fiap.argus.domain.Satellite;
import br.com.fiap.argus.domain.SpaceDebris;

public interface ArgusEngineInterface {
    boolean checkCollisionRisk(Satellite satellite, SpaceDebris debris);
    void executeAutoManeuver(Satellite satellite);
}
