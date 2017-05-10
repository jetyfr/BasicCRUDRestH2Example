package org.example.domain.observation;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BooleanObservation extends Observation<Boolean> {

	private Boolean value;

	public BooleanObservation(ObservationPK observationPK, Boolean value) {
		super();
		this.observationPK = observationPK;
		this.value = value;
	}
}
