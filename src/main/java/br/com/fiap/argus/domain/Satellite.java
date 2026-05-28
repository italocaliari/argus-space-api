package br.com.fiap.argus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ARGUS_SATELLITE")
public class Satellite extends SpaceObject {

    // 🌟 O atributo 'private UUID id' e o '@Id' foram removidos daqui porque já vêm do pai!
    private String operator;
    private double fuelLevel;
    private boolean isActive;

    protected Satellite() {
        super(null, 0, 0, 0);
    }

    public Satellite(String name, double latitude, double longitude, double altitude, String operator, double fuelLevel) {
        super(name, latitude, longitude, altitude);
        this.operator = operator;
        this.fuelLevel = fuelLevel;
        this.isActive = true;
    }

    public void consumeFuel(double amount) {
        if (amount > fuelLevel) {
            throw new IllegalStateException("Combustível insuficiente para realizar a manobra orbital Argus.");
        }
        this.fuelLevel -= amount;
    }

    @Override
    public String getObjectRiskProfile() {
        return "Ativo Comercial Crítico - Prioridade Máxima de Desvio Argus";
    }

    public double getFuelLevel() { return fuelLevel; }
    public String getOperator() { return operator; }
    public boolean isActive() { return isActive; }
}
