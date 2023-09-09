package uz.airport.service;

import uz.airport.dto.CityDto;
import uz.airport.dto.ResponseDto;

import java.util.List;

public interface CityService {
    ResponseDto<CityDto> addCity(CityDto cityDto);

    ResponseDto<CityDto> editCity(CityDto cityDto);

    ResponseDto<List<CityDto>> getAllCity();

    ResponseDto<CityDto> getById(Integer id);

    ResponseDto<CityDto> deleteById(Integer id);
}
