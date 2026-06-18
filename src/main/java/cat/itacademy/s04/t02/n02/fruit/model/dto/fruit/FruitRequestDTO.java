package cat.itacademy.s04.t02.n02.fruit.model.dto.fruit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitRequestDTO {
    @NotBlank
    private String name;
    @Positive
    private int weightInKilos;
    @NotNull
    private Long providerId;
}
