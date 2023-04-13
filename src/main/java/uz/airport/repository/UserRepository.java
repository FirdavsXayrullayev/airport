package uz.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.airport.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
