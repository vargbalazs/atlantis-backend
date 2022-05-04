package api.atlantis.repository.interfaces.app.planning;

import api.atlantis.domain.app.planning.Version;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"costAccType", "company", "plant"})
    List<Version> findAll();
}
