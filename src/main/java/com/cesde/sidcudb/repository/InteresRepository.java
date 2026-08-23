package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.Interes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresRepository extends JpaRepository<Interes, Long> {
}