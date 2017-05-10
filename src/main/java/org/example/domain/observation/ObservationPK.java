package org.example.domain.observation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.example.domain.Measure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservationPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "MEASURE_ID")
	private Measure measure;
	@Temporal(TemporalType.TIMESTAMP)
	private Date measureTime;

}
