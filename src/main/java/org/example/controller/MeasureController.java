package org.example.controller;

import java.util.List;

import org.example.domain.Measure;
import org.example.domain.Measure.MeasureType;
import org.example.domain.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasureController {

	@Autowired
	private MeasureRepository measureRepository;

	@GetMapping("/measures")
	public ResponseEntity<List<Measure>> getAllMeasures() {
		List<Measure> measures = measureRepository.findAll();
		return new ResponseEntity<List<Measure>>(measures, HttpStatus.OK);
	}

	@GetMapping("/measures/{id}")
	public ResponseEntity<Measure> getMeasureById(@PathVariable Long id) {
		Measure measure = measureRepository.findOne(id);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}

	@GetMapping("/measures/type/{measureType}")
	public ResponseEntity<List<Measure>> getMeasureByMeasureType(@PathVariable MeasureType measureType) {
		List<Measure> measures = measureRepository.findByMeasureType(measureType);
		return new ResponseEntity<List<Measure>>(measures, HttpStatus.OK);
	}

	@PostMapping("/measures")
	public ResponseEntity<Measure> createMeasure(@RequestBody Measure measure) {
		Measure savedMeasure = measureRepository.save(measure);
		return new ResponseEntity<Measure>(savedMeasure, HttpStatus.OK);
	}

	@PutMapping("/measures/{id}")
	public ResponseEntity<Measure> updateCustomer(@PathVariable Long id, @RequestBody Measure inputMeasure) {
		Measure dbMeasure = measureRepository.findOne(id);
		dbMeasure.setDevice(inputMeasure.getDevice());
		dbMeasure.setProperty(inputMeasure.getProperty());
		dbMeasure.setUom(inputMeasure.getUom());
		dbMeasure.setMeasureType(inputMeasure.getMeasureType());
		Measure savedMeasure = measureRepository.save(dbMeasure);
		return new ResponseEntity<Measure>(savedMeasure, HttpStatus.OK);
	}

	@DeleteMapping("/measures/{id}")
	public ResponseEntity<Long> deleteCustomer(@PathVariable Long id) {
		measureRepository.delete(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

}
