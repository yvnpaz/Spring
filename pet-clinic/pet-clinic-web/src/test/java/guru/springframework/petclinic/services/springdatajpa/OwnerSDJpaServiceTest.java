package guru.springframework.petclinic.services.springdatajpa;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.repositories.OwnerRepository;
import guru.springframework.petclinic.repositories.PetRepository;
import guru.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownersSet =  new HashSet<>();
        ownersSet.add(Owner.builder().id(1L).build());
        ownersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownersSet);

        Set<Owner> owners =  service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findByID() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(returnOwner));

        Owner owner = service.findByID(1L);

        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findByIDNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findByID(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner saveOwner = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(saveOwner);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }
}