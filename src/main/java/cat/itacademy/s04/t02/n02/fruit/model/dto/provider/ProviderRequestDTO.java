package cat.itacademy.s04.t02.n02.fruit.model.dto.provider;

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
    @NotBlank
    private String country;
}
