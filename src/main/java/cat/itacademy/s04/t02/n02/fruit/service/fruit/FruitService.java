package cat.itacademy.s04.t02.n02.fruit.service.fruit;

import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.model.entity.Fruit;

import java.util.List;

public interface FruitService {
    FruitResponseDTO createFruit(FruitRequestDTO fruitRequestDTO);

    List<FruitResponseDTO> findFruitsByProviderId(Long providerId);
}
