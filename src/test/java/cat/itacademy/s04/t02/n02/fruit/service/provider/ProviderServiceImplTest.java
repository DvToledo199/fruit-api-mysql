package cat.itacademy.s04.t02.n02.fruit.service.provider;

import cat.itacademy.s04.t02.n02.fruit.exception.ProviderAlreadyExistsException;
import cat.itacademy.s04.t02.n02.fruit.exception.ProviderHasFruitsException;
import cat.itacademy.s04.t02.n02.fruit.exception.ProviderNotFoundException;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderRequestDTO;
import cat.itacademy.s04.t02.n02.fruit.model.dto.provider.ProviderResponseDTO;
import cat.itacademy.s04.t02.n02.fruit.model.entity.Provider;
import cat.itacademy.s04.t02.n02.fruit.repository.fruit.FruitRepository;
import cat.itacademy.s04.t02.n02.fruit.repository.provider.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProviderServiceImplTest {

    @Mock
    private ProviderRepository providerRepository;

    @Mock
    private FruitRepository fruitRepository;

    @InjectMocks
    private ProviderServiceImpl providerService;

    @Test
    void createProvider_WhenDataIsValid_ShouldCreateProvider() {
        ProviderRequestDTO request = new ProviderRequestDTO("Mercadona", "Spain");

        when(providerRepository.existsByName("Mercadona")).thenReturn(false);

        ProviderResponseDTO response = providerService.createProvider(request);

        assertEquals("Mercadona", response.getName());
        assertEquals("Spain", response.getCountry());
        verify(providerRepository).save(any(Provider.class));
    }

    @Test
    void createProvider_WhenNameAlreadyExists_ShouldThrowException() {
        ProviderRequestDTO request = new ProviderRequestDTO("Mercadona", "Spain");

        when(providerRepository.existsByName("Mercadona")).thenReturn(true);

        assertThrows(ProviderAlreadyExistsException.class,
                () -> providerService.createProvider(request));
    }

    @Test
    void updateProvider_WhenProviderExists_ShouldUpdateProvider() {
        Provider provider = new Provider();
        provider.setId(1L);
        provider.setName("OldName");
        provider.setCountry("France");

        ProviderRequestDTO request = new ProviderRequestDTO("NewName", "Spain");

        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));
        when(providerRepository.existsByName("NewName")).thenReturn(false);

        ProviderResponseDTO response = providerService.updateProvider(1L, request);

        assertEquals("NewName", response.getName());
        assertEquals("Spain", response.getCountry());
        verify(providerRepository).save(provider);
    }

    @Test
    void updateProvider_WhenProviderDoesNotExist_ShouldThrowException() {
        ProviderRequestDTO request = new ProviderRequestDTO("NewName", "Spain");

        when(providerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ProviderNotFoundException.class,
                () -> providerService.updateProvider(1L, request));
    }

    @Test
    void deleteProvider_WhenProviderHasFruits_ShouldThrowException() {
        Provider provider = new Provider();
        provider.setId(1L);

        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));
        when(fruitRepository.existsByProviderId(1L)).thenReturn(true);

        assertThrows(ProviderHasFruitsException.class,
                () -> providerService.deleteProvider(1L));
    }

    @Test
    void deleteProvider_WhenProviderHasNoFruits_ShouldDeleteProvider() {
        Provider provider = new Provider();
        provider.setId(1L);

        when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));
        when(fruitRepository.existsByProviderId(1L)).thenReturn(false);

        providerService.deleteProvider(1L);

        verify(providerRepository).delete(provider);
    }
}
