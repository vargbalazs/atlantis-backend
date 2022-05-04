package api.atlantis.repository.interfaces.app.planning;

import api.atlantis.domain.app.planning.CapPlanningItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapPlanningItemRepository extends JpaRepository<CapPlanningItem, Long> {
}
