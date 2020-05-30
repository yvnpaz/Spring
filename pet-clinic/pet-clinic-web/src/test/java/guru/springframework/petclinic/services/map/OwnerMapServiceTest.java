package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerMapService.findByID(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner);

        assertEquals(id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
       ownerMapService.deleteById(ownerId);

       assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findByID(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner findOwnerByLastName = ownerMapService.findByLastName(lastName);

        assertNotNull(findOwnerByLastName);
        assertEquals(ownerId, findOwnerByLastName.getId());
        assertEquals(lastName, findOwnerByLastName.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner findOwnerByLastName = ownerMapService.findByLastName("foo");

        assertNull(findOwnerByLastName);
    }
}