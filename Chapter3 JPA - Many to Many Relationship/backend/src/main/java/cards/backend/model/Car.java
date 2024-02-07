//Car.java
package cards.backend.model;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="explanation", nullable=true, length=512)
    private String description;

    private String brand, model, color, registrationNumber;
    private int modelYear, price;

    // Each car belongs to one owner
    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners = new HashSet<>();

    public Car(String brand, String model, String color, String registrationNumber, int modelYear,
            int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owners.add(owner);
    }
}
