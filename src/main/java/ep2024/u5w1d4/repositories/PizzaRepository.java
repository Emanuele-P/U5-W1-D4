package ep2024.u5w1d4.repositories;

import ep2024.u5w1d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    Optional<Pizza> findByName(String name);

    Optional<Pizza> findByNameStartingWithIgnoreCase(String partialName);

}
