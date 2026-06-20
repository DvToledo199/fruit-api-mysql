package cat.itacademy.s04.t02.n02.fruit.service.provider;

import cat.itacademy.s04.t02.n02.fruit.exception.ProviderHasFruitsException;
import lombok.RequiredArgsConstructor;

import cat.itacademy.s04.t02.n02.fruit.exception.ProviderAlreadyExistsException;
import cat.itacademy.s04.t02.n02.fruit.exception.ProviderNotFoundException;
import cat.itacademy.s04.t02.n02.fruit.model.entity.Provider;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.repository.fruit.FruitRepository;
import cat.itacademy.s04.t02.n02.fruit.repository.provider.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final FruitRepository fruitRepository;

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

    @Override
    public ProviderResponseDTO updateProvider(Long id, ProviderRequestDTO providerRequestDTO) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException());
        boolean exists = providerRepository.existsByName(providerRequestDTO.getName());
        if (exists && !provider.getName().equals(providerRequestDTO.getName())) {
            throw new ProviderAlreadyExistsException();
        }
        provider.setName(providerRequestDTO.getName());
        provider.setCountry(providerRequestDTO.getCountry());
        providerRepository.save(provider);

        return new ProviderResponseDTO(
                provider.getId(),
                provider.getName(),
                provider.getCountry()
        );
    }

    @Override
    public void deleteProvider(Long id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException());
        boolean exists = fruitRepository.existsByProviderId(id);
        if (exists) {
            throw new ProviderHasFruitsException();
        }
        providerRepository.delete(provider);




    }
}
