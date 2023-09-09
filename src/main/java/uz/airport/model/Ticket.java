package uz.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(generator = "ticketSeqId")
    @SequenceGenerator(name = "ticketSeqId", sequenceName = "ticket_seq_id", allocationSize = 1)
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
