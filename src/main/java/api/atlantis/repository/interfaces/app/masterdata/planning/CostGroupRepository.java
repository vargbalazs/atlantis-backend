package api.atlantis.repository.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostGroup;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostGroupRepository extends JpaRepository<CostGroup, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company"})
    List<CostGroup> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company"})
    List<CostGroup> findByCompanyId(Long companyId);

}
