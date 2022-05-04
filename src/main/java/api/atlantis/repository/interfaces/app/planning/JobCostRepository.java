package api.atlantis.repository.interfaces.app.planning;

import api.atlantis.domain.app.planning.JobCost;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCostRepository extends JpaRepository<JobCost, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"hcPlanningItem", "costAccount"})
    List<JobCost> findByHcPlanningItemId(Long hcPlanningItemId);
}
