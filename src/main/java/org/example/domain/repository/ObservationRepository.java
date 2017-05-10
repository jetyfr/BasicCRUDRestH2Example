package org.example.domain.repository;

import java.util.Date;
import java.util.List;

import org.example.domain.observation.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {

	@Query("SELECT o FROM Observation o WHERE o.observationPK.measure.id = :measureId")
	public List<Observation> findByMeasureId(@Param("measureId") Long measureId);

	@Query("SELECT o FROM Observation o WHERE o.observationPK.measureTime BETWEEN :start AND :end")
	public List<Observation> findByMeasureTimeBetweenOrderByMeasureTimeAsc(@Param("start") Date start,
			@Param("end") Date end);

	@Query("SELECT o FROM Observation o WHERE o.observationPK.measure.id = :measureId AND o.observationPK.measureTime BETWEEN :start AND :end")
	public List<Observation> findByMeasureIdAndMeasureTimeBetweenOrderByMeasureTimeAsc(
			@Param("measureId") Long measureId, @Param("start") Date start, @Param("end") Date end);
}
