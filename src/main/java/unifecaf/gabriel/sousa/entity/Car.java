package unifecaf.gabriel.sousa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import unifecaf.gabriel.sousa.enums.Brand;
import unifecaf.gabriel.sousa.enums.Color;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", length = 200, nullable = false)
    private String model;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "manufacturingYear", nullable = false)
    private Integer manufacturingYear;

    @Column(name = "isNew", nullable = false)
    private Boolean isNew;

    @Column(name = "kmDriven", nullable = false)
    private Float kilometersDriven;

    @Column(name = "isAvaliable", nullable = false)
    private Boolean isAvaliable;
}
