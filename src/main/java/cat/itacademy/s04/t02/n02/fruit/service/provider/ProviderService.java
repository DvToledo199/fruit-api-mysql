package cat.itacademy.s04.t02.n02.fruit.service.provider;

import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderResponseDTO;

public interface ProviderService {

    ProviderResponseDTO createProvider(ProviderRequestDTO providerRequestDTO);

    ProviderResponseDTO updateProvider(Long id, ProviderRequestDTO providerRequestDTO);

    void deleteProvider(Long id);








}
