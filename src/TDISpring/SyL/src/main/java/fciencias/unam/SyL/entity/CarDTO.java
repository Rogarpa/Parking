package fciencias.unam.SyL.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO{
    public long id;
    public String date;
    public String model;
    public String brand;
    public String color;
}
