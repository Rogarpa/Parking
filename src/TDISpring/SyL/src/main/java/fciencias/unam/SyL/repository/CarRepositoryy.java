package fciencias.unam.SyL.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fciencias.unam.SyL.entity.Car;

public interface CarRepositoryy extends JpaRepository<Car, Long> {
}