package br.com.fiap.argus.dto;

public record TelemetryDto(
        String targetObjectName,
        double currentLatitude,
        double currentLongitude,
        double currentAltitude
) {}
