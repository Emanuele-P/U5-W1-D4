package ep2024.u5w1d4.services;

import ep2024.u5w1d4.entities.Pizza;
import ep2024.u5w1d4.exceptions.ItemAlreadyExistsException;
import ep2024.u5w1d4.exceptions.ItemNotFoundException;
import ep2024.u5w1d4.repositories.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void savePizza(Pizza newPizza) {
        if (pizzaRepository.findByNameStartingWithIgnoreCase(newPizza.getName()).isPresent()) {
            log.warn("Pizza " + newPizza.getName() + " already exists!");
            throw new ItemAlreadyExistsException(newPizza.getName());
        }

        pizzaRepository.save(newPizza);
        log.info("New pizza " + newPizza.getName() + " added to menu");
    }

    public Pizza findById(long pizzaId) {
        return pizzaRepository.findById(pizzaId).orElseThrow(() -> new ItemNotFoundException(pizzaId));
    }
}
