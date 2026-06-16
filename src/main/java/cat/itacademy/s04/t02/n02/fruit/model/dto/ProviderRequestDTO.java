package cat.itacademy.s04.t02.n02.fruit.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderRequestDTO {
    @NotBlank
    private String name;
    private String country;
}
