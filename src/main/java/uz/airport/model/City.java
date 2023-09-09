package uz.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(generator = "citySeqId")
    @SequenceGenerator(name = "citySeqId", sequenceName = "city_seq_id", allocationSize = 1)
    private Integer id;
    private String stateName;
    private String cityName;
    private Integer price;
    private String clas;
}
