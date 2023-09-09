package uz.airport.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.airport.dto.CityDto;
import uz.airport.dto.ResponseDto;
import uz.airport.model.City;
import uz.airport.repository.CityRepository;
import uz.airport.service.CityService;
import uz.airport.service.mapper.CityMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    @Override
    public ResponseDto<CityDto> addCity(CityDto cityDto) {
        try {
            return ResponseDto.<CityDto>builder()
                    .code(0)
                    .message("OK")
                    .success(true)
                    .data(cityMapper.toDto(cityRepository.save(cityMapper.toEntity(cityDto))))
                    .build();
        }catch (Exception e){
            return ResponseDto.<CityDto>builder()
                    .code(1)
                    .message("Database Error")
                    .success(false)
                    .data(cityDto)
                    .build();
        }
    }

    @Override
    public ResponseDto<CityDto> editCity(CityDto cityDto) {
        if (cityDto.getId() == null){
            return ResponseDto.<CityDto>builder()
                    .code(-2)
                    .message("Validation Error")
                    .data(cityDto)
                    .success(false)
                    .build();
        }
        Optional<City> optionalCity = cityRepository.findById(cityDto.getId());
        if (optionalCity.isEmpty()){
            return ResponseDto.<CityDto>builder()
                    .code(-1)
                    .message("Not Found")
                    .success(false)
                    .data(cityDto)
                    .build();
        }
        City city = optionalCity.get();
        if (cityDto.getCityName() != null) city.setCityName(cityDto.getCityName());
        if (cityDto.getClas() != null) city.setClas(cityDto.getClas());
        if (cityDto.getPrice() != null) city.setPrice(cityDto.getPrice());
        if (cityDto.getStateName() != null) city.setStateName(cityDto.getStateName());
        try {
            cityRepository.save(city);
            return ResponseDto.<CityDto>builder()
                    .code(0)
                    .message("OK")
                    .data(cityMapper.toDto(city))
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<CityDto>builder()
                    .code(1)
                    .message("Database Error")
                    .data(cityDto)
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<List<CityDto>> getAllCity() {
        return ResponseDto.<List<CityDto>>builder()
                .code(0)
                .message("OK")
                .success(true)
                .data(cityRepository.findAll().stream().map(cityMapper::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<CityDto> getById(Integer id) {
        return cityRepository.findById(id)
                .map(city -> ResponseDto.<CityDto>builder()
                        .code(0)
                        .message("OK")
                        .success(true)
                        .data(cityMapper.toDto(city))
                        .build())
                .orElse(ResponseDto.<CityDto>builder()
                        .code(-1)
                        .message("Not Found")
                        .success(false)
                        .build());
    }

    @Override
    public ResponseDto<CityDto> deleteById(Integer id) {
        return cityRepository.findById(id)
                .map(city -> {
                    cityRepository.deleteById(id);
                    return ResponseDto.<CityDto>builder()
                            .code(0)
                            .message("OK")
                            .data(cityMapper.toDto(city))
                            .success(true)
                            .build();
                })
                .orElse(ResponseDto.<CityDto>builder()
                        .code(-1)
                        .message("Not Found")
                        .success(false)
                        .build());
    }
}
