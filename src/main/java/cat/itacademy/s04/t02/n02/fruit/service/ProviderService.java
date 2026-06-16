package cat.itacademy.s04.t02.n02.fruit.service;

import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderResponseDTO;

public interface ProviderService {

    ProviderResponseDTO createProvider(ProviderRequestDTO providerRequestDTO);


}
