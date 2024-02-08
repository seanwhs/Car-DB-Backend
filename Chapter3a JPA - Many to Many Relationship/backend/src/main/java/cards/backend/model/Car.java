//Car.java
package cards.backend.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "explanation", nullable = true, length = 512)
    private String description;

    private String brand, model, color, registrationNumber;
    private int modelYear, price;

    @ManyToMany(mappedBy = "cars", fetch = FetchType.EAGER)
    private Set<Owner> owners = new HashSet<>();

    public Car(String brand, String model, String color, String registrationNumber, int modelYear, int price,
            Set<Owner> owners) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owners = owners;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Or whatever field you want to use for hashing
    }
}
