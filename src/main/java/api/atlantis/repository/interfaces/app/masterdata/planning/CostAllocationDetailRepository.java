package api.atlantis.repository.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocationDetail;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostAllocationDetailRepository extends JpaRepository<CostAllocationDetail, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"costAllocation", "baseCostCenter",
            "recCostCenter"})
    List<CostAllocationDetail> findAllByCostAllocationId(Long id);

    @Modifying
    @Query("DELETE FROM CostAllocationDetail cad WHERE cad.costAllocation.id = :id")
    void deleteAllByCostAllocationId(@Param("id") Long id);
}
