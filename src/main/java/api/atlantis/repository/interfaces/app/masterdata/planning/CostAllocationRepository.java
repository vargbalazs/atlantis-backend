package api.atlantis.repository.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostAllocationRepository extends JpaRepository<CostAllocation, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"costAccount",
            "company", "plant", "allocCostCenter"})
    List<CostAllocation> findAll();
}
