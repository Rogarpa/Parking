package fciencias.unam.SyL.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carr")
public class Carr{
    
    @Id
    @Column(name = "id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDateTime date;
    public String model;
    public String brand;
    public String color;
    public boolean parked;

    public boolean getParked(){
        return this.parked;
    }
}
