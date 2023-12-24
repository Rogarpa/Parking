package fciencias.unam.SyL.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car{
    public long id;
    public LocalDateTime date;
    public String model;
    public String brand;
    public String color;
    public boolean parked;

    public boolean getParked(){
        return this.parked;
    }
}
