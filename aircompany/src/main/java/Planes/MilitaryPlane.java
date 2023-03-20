package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private final MilitaryType militeryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militeryType = type;
    }

    public MilitaryType getType() {
        return militeryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", String.format("militeryType = %s}", militeryType));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return militeryType == that.militeryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militeryType);
    }
}
