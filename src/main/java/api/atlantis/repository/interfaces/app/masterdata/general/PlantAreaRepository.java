package api.atlantis.repository.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.PlantArea;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantAreaRepository extends JpaRepository<PlantArea, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"plant", "plant.company"})
    List<PlantArea> findAll();
}
