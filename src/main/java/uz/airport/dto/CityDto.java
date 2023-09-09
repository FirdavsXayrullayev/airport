package uz.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Integer id;
    private String stateName;
    private String cityName;
    private Integer price;
    private String clas;
}
