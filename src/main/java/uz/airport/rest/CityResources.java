package uz.airport.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.airport.dto.CityDto;
import uz.airport.dto.ResponseDto;
import uz.airport.service.CityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("city")
@SecurityRequirement(name = "Authorization")
public class CityResources {
    private final CityService cityService;
    @PostMapping("add-city")
    public ResponseDto<CityDto> addCity(@RequestBody CityDto cityDto){
        return cityService.addCity(cityDto);
    }
    @PatchMapping("edit-city")
    public ResponseDto<CityDto> editCity(@RequestBody CityDto cityDto){
        return cityService.editCity(cityDto);
    }
    @GetMapping("get-all-city")
    public ResponseDto<List<CityDto>> getAllCity(){
        return cityService.getAllCity();
    }
    @GetMapping("get-by-id")
    public ResponseDto<CityDto> getById(@RequestParam Integer id){
        return cityService.getById(id);
    }
    @DeleteMapping("delete-by-id")
    public ResponseDto<CityDto> deleteById(@RequestParam Integer id){
        return cityService.deleteById(id);
    }

}
