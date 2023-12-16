package fciencias.unam.SyL.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fciencias.unam.SyL.entity.Car;
import jakarta.transaction.Transactional;

public interface CarRepositoryy extends JpaRepository<Car, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE car RESTART IDENTITY", nativeQuery =true)
    void truncateCarDB();
}