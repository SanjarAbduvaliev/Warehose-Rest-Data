package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Supplier;
import com.example.warehoserestdata.projection.CustomSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "supplier",excerptProjection = CustomSupplier.class)
public interface SuplierRepository extends JpaRepository<Supplier,Integer> {
    @RestResource(path = "byName")
    public Page<Supplier> findAllByName(@Param("name") String name, Pageable pageable);
}
