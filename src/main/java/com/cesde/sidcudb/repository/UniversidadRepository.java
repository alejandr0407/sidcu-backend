package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
}