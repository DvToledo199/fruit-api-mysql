package cat.itacademy.s04.t02.n02.fruit.service.fruit;

import cat.itacademy.s04.t02.n02.fruit.exception.ProviderNotFoundException;
import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.fruit.FruitResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.model.entity.Fruit;
import cat.itacademy.s04.t02.n02.fruit.model.entity.Provider;
import cat.itacademy.s04.t02.n02.fruit.repository.fruit.FruitRepository;
import cat.itacademy.s04.t02.n02.fruit.repository.provider.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;
    private final ProviderRepository providerRepository;

    @Override
    public FruitResponseDTO createFruit(FruitRequestDTO fruitRequestDTO) {
        Provider provider = providerRepository.findById(fruitRequestDTO.getProviderId())
                .orElseThrow(() -> new ProviderNotFoundException());

        Fruit fruit = new Fruit();
        fruit.setName(fruitRequestDTO.getName());
        fruit.setWeightInKilos(fruitRequestDTO.getWeightInKilos());
        fruit.setProvider(provider);
        fruitRepository.save(fruit);
        return new FruitResponseDTO(
                fruit.getId(),
                fruit.getName(),
                fruit.getWeightInKilos(),
                fruit.getProvider().getId()
        );
    }

    @Override
    public List<FruitResponseDTO> findFruitsByProviderId(Long providerId) {
        providerRepository.findById(providerId)
                .orElseThrow(() -> new ProviderNotFoundException());
        List<Fruit> fruits = fruitRepository.findByProviderId(providerId);
        List<FruitResponseDTO> fruitResponseDTOList = new ArrayList<>();
        for (Fruit fruit : fruits) {
             FruitResponseDTO fruitResponseDTO = new FruitResponseDTO(
                    fruit.getId(),
                    fruit.getName(),
                    fruit.getWeightInKilos(),
                    fruit.getProvider().getId()
            );
            fruitResponseDTOList.add(fruitResponseDTO);
        }
        return fruitResponseDTOList;
    }
}
