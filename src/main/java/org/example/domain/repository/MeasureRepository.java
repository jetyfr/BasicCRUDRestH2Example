package org.example.domain.repository;

import java.util.List;

import org.example.domain.Measure;
import org.example.domain.Measure.MeasureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {

	public List<Measure> findByMeasureType(MeasureType measureType);
}
