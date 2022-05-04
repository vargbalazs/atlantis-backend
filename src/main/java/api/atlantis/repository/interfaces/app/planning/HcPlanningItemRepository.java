package api.atlantis.repository.interfaces.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HcPlanningItemRepository extends JpaRepository<HcPlanningItem, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant", "costCenter",
            "costAccType", "costGroup", "job", "job.department"})
    List<HcPlanningItem> findByCostCenterIdAndCostAccTypeId(Long costCenterId, Long costAccTypeId);
}
