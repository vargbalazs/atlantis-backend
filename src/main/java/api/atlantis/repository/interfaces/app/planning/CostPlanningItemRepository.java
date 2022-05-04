package api.atlantis.repository.interfaces.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostPlanningItemRepository extends JpaRepository<CostPlanningItem, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant", "costCenter",
    "costAccType", "costGroup", "currency", "costAccount"})
    List<CostPlanningItem> findByCostCenterIdAndCostAccTypeId(Long costCenterId, Long costAccTypeId);
}
