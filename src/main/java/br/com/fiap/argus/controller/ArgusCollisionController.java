package br.com.fiap.argus.controller;

import br.com.fiap.argus.domain.Satellite;
import br.com.fiap.argus.domain.SpaceDebris;
import br.com.fiap.argus.dto.ArgusAlertDto; // Import do DTO que faltava
import br.com.fiap.argus.dto.TelemetryDto;
import br.com.fiap.argus.repository.SatelliteRepository;
import br.com.fiap.argus.service.ArgusEngineInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/argus-collision")
public class ArgusCollisionController {

    private final ArgusEngineInterface argusEngine;
    private final SatelliteRepository satelliteRepository;

    public ArgusCollisionController(ArgusEngineInterface argusEngine, SatelliteRepository satelliteRepository) {
        this.argusEngine = argusEngine;
        this.satelliteRepository = satelliteRepository;
    }

    @PostMapping("/analyze")
    public ResponseEntity<?> analyzeMetrics(@RequestBody TelemetryDto telemetry) {
        // Corrigido para a sintaxe nativa de Records do Java (sem o prefixo 'get')
        Satellite satellite = new Satellite(
                telemetry.targetObjectName(),
                telemetry.currentLatitude(),
                telemetry.currentLongitude(),
                telemetry.currentAltitude(),
                "Ford-Constellation",
                85.0
        );

        SpaceDebris debris = new SpaceDebris(
                "Fragmento-Cosmos-2251",
                telemetry.currentLatitude(),
                telemetry.currentLongitude(),
                telemetry.currentAltitude() + 2.1,
                28000.0,
                10.5
        );

        satelliteRepository.save(satellite);

        boolean isCritical = argusEngine.checkCollisionRisk(satellite, debris);

        if (isCritical) {
            argusEngine.executeAutoManeuver(satellite);
            satelliteRepository.save(satellite);

            ArgusAlertDto alert = new ArgusAlertDto(
                    UUID.randomUUID(),
                    satellite.getName(),
                    "VERMELHO (Risco Crítico de Impacto)",
                    "Trajetória Azul Ativada: Altitude recalculada de segurança para " + (satellite.getAltitude() + 15.0) + "km",
                    LocalDateTime.now()
            );

            return ResponseEntity.ok(Map.of(
                    "message", "Ação evasiva autônoma executada com sucesso pelo sistema Argus. Dados persistidos.",
                    "alertData", alert
            ));
        }

        return ResponseEntity.ok(Map.of(
                "message", "Monitoramento Argus: Órbita estável e segura. Dados do satélite registrados no banco."
        ));
    }
}
