package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.domain.Measure;
import org.example.domain.Measure.MeasureType;
import org.example.domain.observation.BooleanObservation;
import org.example.domain.observation.MeasureObservation;
import org.example.domain.observation.Observation;
import org.example.domain.observation.ObservationPK;
import org.example.domain.repository.MeasureRepository;
import org.example.domain.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerComponent implements CommandLineRunner {

	@Autowired
	private MeasureRepository measureRepository;
	@Autowired
	private ObservationRepository observationRepository;

	@Override
	public void run(String... arg0) throws Exception {
		saveSomeMeasures();
		saveSomeMeasureObservations();
		saveSomeBooleanObservations();
	}

	private void saveSomeMeasures() {
		List<Measure> measures = new ArrayList<>();
		measures.add(new Measure(1L, "Termometro", "Temperatura", "ºC", MeasureType.MEASURE_OBSERVATION));
		measures.add(new Measure(2L, "Higrometro", "Humedad", "%", MeasureType.MEASURE_OBSERVATION));
		measures.add(new Measure(3L, "Detector volumetrico", "Presencia", "-", MeasureType.BOOLEAN_OBSERVATION));
		measures.add(new Measure(4L, "Anemometro", "Velocidad del viento", "m/s", MeasureType.MEASURE_OBSERVATION));
		for (Measure measure : measures) {
			measureRepository.save(measure);
		}
	}

	private void saveSomeMeasureObservations() {
		List<Observation> observations = new ArrayList<>();
		Measure measure = measureRepository.findOne(1L);
		observations.add(new MeasureObservation(new ObservationPK(measure, new Date()), 24.5));
		for (Observation observation : observations) {
			observationRepository.save(observation);
		}
	}

	private void saveSomeBooleanObservations() {
		List<Observation> observations = new ArrayList<>();
		Measure measure = measureRepository.findOne(3L);
		observations.add(new BooleanObservation(new ObservationPK(measure, new Date()), true));
		for (Observation observation : observations) {
			observationRepository.save(observation);
		}

	}
}
