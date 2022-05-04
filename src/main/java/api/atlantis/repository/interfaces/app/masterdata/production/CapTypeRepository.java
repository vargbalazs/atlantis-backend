package api.atlantis.repository.interfaces.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapTypeRepository extends JpaRepository<CapType, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<CapType> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<CapType> findCapTypesByPlantId(Long plantId);
}
