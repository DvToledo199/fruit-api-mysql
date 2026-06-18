package cat.itacademy.s04.t02.n02.fruit.model.dto.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderResponseDTO {

    private Long id;
    private String name;
    private String country;
}
