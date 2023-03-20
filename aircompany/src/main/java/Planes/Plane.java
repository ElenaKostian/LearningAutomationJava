package Planes;

import java.util.Objects;

abstract public class Plane {
	private String model; 
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    protected Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMS() {
        return maxSpeed;
    }

    public int Get_Max_Flight_Distance() {
        return maxFlightDistance;
    }

    public int getMinLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String toString() {
        return String.format("Plane{model=%s, maxSpeed=%s, maxFlightDistance=%s, maxLoadCapacity=%s}",
                model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        Plane plane = (Plane) object;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(model, plane.model);
    }


	@Override
	public int hashCode() {
		return Objects.hash(maxFlightDistance, maxLoadCapacity, maxSpeed, model);
	}
}
