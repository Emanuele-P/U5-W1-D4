package ep2024.u5w1d4.entities;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private double price;
    private int calories;

    public Drink(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Drink: " + name + ", " + price + "€" + "---" + calories + " Kcal";
    }
}


