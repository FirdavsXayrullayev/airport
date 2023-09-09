package uz.airport.service.mapper;

import org.mapstruct.Mapper;
import uz.airport.dto.CityDto;
import uz.airport.model.City;

@Mapper(componentModel = "spring")
public abstract class CityMapper implements CommonMapper<CityDto, City>{
}
