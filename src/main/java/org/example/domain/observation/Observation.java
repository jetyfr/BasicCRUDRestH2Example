package org.example.domain.observation;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Observation<T> {

	@JsonIgnore
	@EmbeddedId
	protected ObservationPK observationPK;
	@Transient
	protected Long measureId;
	@Transient
	protected Date measureTime;

	public ObservationPK getObservationPK() {
		return observationPK;
	}

	public void setObservationPK(ObservationPK observationPK) {
		this.observationPK = observationPK;
	}

	public Long getMeasureId() {
		return observationPK.getMeasure().getId();
	}

	public Date getMeasureTime() {
		return observationPK.getMeasureTime();
	}

	public abstract T getValue();

	public abstract void setValue(T t);
}
