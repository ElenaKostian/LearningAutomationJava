package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class experimentalPlane extends Plane {

	private final ExperimentalTypes experimentalType;
	private final ClassificationLevel classificationLevel;

	public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
			ExperimentalTypes type, ClassificationLevel classificationLevel) {
		super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
		this.experimentalType = type;
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	public ExperimentalTypes getExperimentalTypes() {
		return experimentalType;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString().replaceAll("}", String.format(", experimentalType = %s, classificationLevel = %s}", experimentalType, classificationLevel));
	}

}
