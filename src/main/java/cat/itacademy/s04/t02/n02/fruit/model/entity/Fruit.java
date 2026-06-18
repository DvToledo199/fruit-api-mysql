package cat.itacademy.s04.t02.n02.fruit.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fruit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int weightInKilos;
    @ManyToOne
    private Provider provider;
}
