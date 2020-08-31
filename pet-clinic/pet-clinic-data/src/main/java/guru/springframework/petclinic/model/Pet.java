package guru.springframework.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    public Pet() {
    }

    public static PetBuilder builder() {
        return new PetBuilder();
    }

    public static class PetBuilder {
        private String name;
        private PetType petType;
        private Owner owner;
        private LocalDate birthDate;
        private Set<Visit> visits;

        PetBuilder() {
        }

        public PetBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder petType(PetType petType) {
            this.petType = petType;
            return this;
        }

        public PetBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public PetBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PetBuilder visits(Set<Visit> visits) {
            this.visits = visits;
            return this;
        }

        public Pet build() {
            return new Pet(name, petType, owner, birthDate, visits);
        }

        public String toString() {
            return "Pet.PetBuilder(name=" + this.name + ", petType=" + this.petType + ", owner=" + this.owner + ", birthDate=" + this.birthDate + ", visits=" + this.visits + ")";
        }
    }
}
