package api.atlantis.repository.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcOtherCost;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrcOtherCostRepository extends JpaRepository<FrcOtherCost, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"costAccount", "costCenter", "frc"})
    List<FrcOtherCost> getFrcOtherCostByFrcId(Long frcId);
}
