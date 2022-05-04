package api.atlantis.repository.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostAccountRepository extends JpaRepository<CostAccount, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "costGroup"})
    List<CostAccount> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "costGroup"})
    List<CostAccount> findByCompanyIdAndYear(Long companyId, int year);
}
