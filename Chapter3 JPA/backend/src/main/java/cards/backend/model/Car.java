//Car.java
package cards.backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner")
    private Owner owner;

    public Car(String brand, String model, String color, String registrationNumber, int modelYear,
            int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner=owner;
    }

    
}
