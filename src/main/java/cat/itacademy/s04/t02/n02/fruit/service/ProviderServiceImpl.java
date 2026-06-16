package cat.itacademy.s04.t02.n02.fruit.service;

import cat.itacademy.s04.t02.n02.fruit.exception.ProviderAlreadyExistsException;
import cat.itacademy.s04.t02.n02.fruit.model.Provider;
import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.ProviderResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public ProviderResponseDTO createProvider(ProviderRequestDTO providerRequestDTO) {
        boolean exists = providerRepository.existsByName(providerRequestDTO.getName());
        if (exists) {
            throw new ProviderAlreadyExistsException();
        }
        Provider provider = new Provider();
        provider.setName(providerRequestDTO.getName());
        provider.setCountry(providerRequestDTO.getCountry());
        providerRepository.save(provider);
        return new ProviderResponseDTO(
                provider.getId(),
                provider.getName(),
                provider.getCountry()
        );
    }
}
