package br.com.fiap.argus.domain;

import jakarta.persistence.Id; // Importado aqui
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class SpaceObject {

    @Id // 🌟 O ID AGORA É DEFINIDO AQUI NA CLASSE PAI
    private UUID id;

    protected String name;
    protected double latitude;
    protected double longitude;
    protected double altitude;
    protected LocalDateTime lastUpdated;

    protected SpaceObject(String name, double latitude, double longitude, double altitude) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.lastUpdated = LocalDateTime.now();
    }

    public abstract String getObjectRiskProfile();

    public UUID getId() { return id; }
    public String getName() { return name; }
    public double getAltitude() { return altitude; }
}
