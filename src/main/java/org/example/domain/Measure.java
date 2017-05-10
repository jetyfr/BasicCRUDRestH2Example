package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measure {

	@Id
	private Long id;
	private String device;
	private String property;
	private String uom;
	private MeasureType measureType;

	public enum MeasureType {
		BOOLEAN_OBSERVATION, MEASURE_OBSERVATION;
	}
}
