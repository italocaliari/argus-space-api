package br.com.fiap.argus.domain;

public class SpaceDebris extends SpaceObject {
    private double velocityKmh;
    private double sizeCm;

    public SpaceDebris(String name, double latitude, double longitude, double altitude, double velocityKmh, double sizeCm) {
        super(name, latitude, longitude, altitude);
        this.velocityKmh = velocityKmh;
        this.sizeCm = sizeCm;
    }

    @Override
    public String getObjectRiskProfile() {
        return "Detrito Espacial Perigoso - Tamanho: " + sizeCm + "cm - Velocidade: " + velocityKmh + "km/h";
    }
}
