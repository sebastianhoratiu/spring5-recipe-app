package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure= unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", optionalUnitOfMeasure.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure= unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", optionalUnitOfMeasure.get().getDescription());
    }
}