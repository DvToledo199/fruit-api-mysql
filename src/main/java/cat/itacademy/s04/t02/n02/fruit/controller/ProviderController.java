package cat.itacademy.s04.t02.n02.fruit.controller;

import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping

    public ProviderResponseDTO createProvider(@RequestBody ProviderRequestDTO providerRequestDTO) {
        return providerService.createProvider(providerRequestDTO);
    }
}
