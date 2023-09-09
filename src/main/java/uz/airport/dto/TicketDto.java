package uz.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birtDate;
    private String gender;
    private String fromCity;
    private String toCity;
    private Date date;
}
