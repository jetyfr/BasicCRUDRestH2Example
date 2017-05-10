package org.example.domain.observation;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class MeasureObservation extends Observation<Double> {

	private Double value;

	public MeasureObservation(ObservationPK observationPK, Double value) {
		super();
		this.observationPK = observationPK;
		this.value = value;
	}

}
