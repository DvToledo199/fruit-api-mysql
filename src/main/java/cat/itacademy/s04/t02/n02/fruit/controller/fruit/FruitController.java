package cat.itacademy.s04.t02.n02.fruit.controller.fruit;

import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.service.fruit.FruitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FruitResponseDTO saveFruit(@Valid @RequestBody FruitRequestDTO fruitRequestDTO) {
        return fruitService.createFruit(fruitRequestDTO);
    }

    @GetMapping("/provider/{providerId}")
    public List<FruitResponseDTO> findFruitsByProviderId(@PathVariable Long providerId) {
        return fruitService.findFruitsByProviderId(providerId);
    }
}
