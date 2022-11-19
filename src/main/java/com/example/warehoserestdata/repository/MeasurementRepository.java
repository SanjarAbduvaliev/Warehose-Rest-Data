package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Measurement;
import com.example.warehoserestdata.projection.CustomMeasurment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "measurment",excerptProjection = CustomMeasurment.class)
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    @RestResource(path = "byNameSort")
    public Page<Measurement> findAllByName(@Param("name=") String name, Pageable pageable);
}
