package uz.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.airport.dto.CityDto;
import uz.airport.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
