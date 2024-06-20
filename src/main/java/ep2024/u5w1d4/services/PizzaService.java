package ep2024.u5w1d4.services;

import ep2024.u5w1d4.entities.Pizza;
import ep2024.u5w1d4.exceptions.ItemAlreadyExistsException;
import ep2024.u5w1d4.exceptions.ItemNotFoundException;
import ep2024.u5w1d4.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void savePizza(Pizza newPizza) {
        if (pizzaRepository.findByNameStartingWithIgnoreCase(newPizza.getName()).isPresent()) {
            System.err.println("Pizza " + newPizza.getName() + " already exists!");
            throw new ItemAlreadyExistsException(newPizza.getName());
        }

        pizzaRepository.save(newPizza);
        System.out.println("New pizza " + newPizza.getName() + " added to menu");
    }

    public Pizza findById(long pizzaId) {
        return pizzaRepository.findById(pizzaId).orElseThrow(() -> new ItemNotFoundException(pizzaId));
    }

    public void findByIdAndDelete(long pizzaId) {
        Pizza found = this.findById(pizzaId);
        pizzaRepository.delete(found);
        System.out.println("Pizza with id " + pizzaId + " has been deleted");
    }

    public long count() {
        return pizzaRepository.count();
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public void findByIdAndUpdate(long pizzaId, Pizza updatedPizza) {
        Pizza found = this.findById(pizzaId);
        found.setName(updatedPizza.getName());
        found.setPrice(updatedPizza.getPrice());
        found.setCalories(updatedPizza.getCalories());
        found.setToppings(updatedPizza.getToppings());

        pizzaRepository.save(found);
        System.out.println("Pizza " + updatedPizza.getName() + " updated!");
    }
}
