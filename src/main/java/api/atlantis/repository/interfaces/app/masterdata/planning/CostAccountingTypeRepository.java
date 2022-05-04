package api.atlantis.repository.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostAccountingTypeRepository extends JpaRepository<CostAccountingType, Long> {
}
