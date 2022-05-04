package api.atlantis.repository.interfaces.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapUnit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapUnitRepository extends JpaRepository<CapUnit, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<CapUnit> findAll();
}
