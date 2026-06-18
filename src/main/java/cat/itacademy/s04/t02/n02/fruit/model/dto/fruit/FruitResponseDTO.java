package cat.itacademy.s04.t02.n02.fruit.model.dto.fruit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FruitResponseDTO {
    private Long id;
    private String name;
    private int weightInKilos;
    private Long providerId;
}
