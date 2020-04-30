package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.Speciality;
import guru.springframework.petclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findByID(Long id) {
        return super.findById(id);
    }
}
