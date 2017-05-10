package org.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.domain.observation.BooleanObservation;
import org.example.domain.observation.MeasureObservation;
import org.example.domain.observation.Observation;
import org.example.domain.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservationController {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	@Autowired
	private ObservationRepository observationRepository;

	@GetMapping("/observations")
	public ResponseEntity<List<Observation>> getAllObservations() {
		List<Observation> observations = new ArrayList<>();
		observations.addAll(observationRepository.findAll());
		return new ResponseEntity<List<Observation>>(observations, HttpStatus.OK);
	}

	@GetMapping("/observations/{measureId}")
	public ResponseEntity<List<Observation>> getObservationsByMeasureId(@PathVariable Long measureId) {
		return new ResponseEntity<List<Observation>>(observationRepository.findByMeasureId(measureId), HttpStatus.OK);
	}

	@GetMapping("/observations/{start}/{end}")
	public ResponseEntity<List<Observation>> getObservationsByInterval(
			@PathVariable @DateTimeFormat(pattern = DATE_FORMAT) Date start,
			@PathVariable @DateTimeFormat(pattern = DATE_FORMAT) Date end) {
		return new ResponseEntity<List<Observation>>(
				observationRepository.findByMeasureTimeBetweenOrderByMeasureTimeAsc(start, end), HttpStatus.OK);
	}

	@GetMapping("/observations/{measureId}/{start}/{end}")
	public ResponseEntity<List<Observation>> getObservationsByMeasureIdAndInterval(@PathVariable Long measureId,
			@PathVariable @DateTimeFormat(pattern = DATE_FORMAT) Date start,
			@PathVariable @DateTimeFormat(pattern = DATE_FORMAT) Date end) {
		return new ResponseEntity<List<Observation>>(
				observationRepository.findByMeasureIdAndMeasureTimeBetweenOrderByMeasureTimeAsc(measureId, start, end),
				HttpStatus.OK);
	}

	@PostMapping("/observations/measure")
	public ResponseEntity<Observation> createMeasureObservation(@RequestBody MeasureObservation observation) {
		return new ResponseEntity<Observation>(observationRepository.save(observation), HttpStatus.OK);
	}

	@PostMapping("/observations/boolean")
	public ResponseEntity<Observation> createBooleanObservation(@RequestBody BooleanObservation observation) {
		return new ResponseEntity<Observation>(observationRepository.save(observation), HttpStatus.OK);
	}
}
