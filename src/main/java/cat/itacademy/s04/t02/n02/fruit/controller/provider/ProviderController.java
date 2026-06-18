package cat.itacademy.s04.t02.n02.fruit.controller.provider;

import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.service.provider.ProviderService;
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
    @PutMapping("/{id}")
    public ProviderResponseDTO updateProvider(@PathVariable Long id, @RequestBody ProviderRequestDTO providerRequestDTO) {
        return providerService.updateProvider(id, providerRequestDTO);
    }
}
