package uz.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "userIdSeq")
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
