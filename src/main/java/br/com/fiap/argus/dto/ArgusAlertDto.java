package br.com.fiap.argus.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ArgusAlertDto(
        UUID alertId,
        String satelliteName,
        String riskLevel,
        String calculatedSafeVector,
        LocalDateTime timestamp
) {}
