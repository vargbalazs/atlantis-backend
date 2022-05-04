package api.atlantis.repository.interfaces.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapGroup;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapGroupRepository extends JpaRepository<CapGroup, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"capType", "capUnit", "company", "plant"})
    List<CapGroup> findAll();
}
