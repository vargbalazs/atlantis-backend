package api.atlantis.repository.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkVersion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvkVersionRepository extends JpaRepository<ProvkVersion, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<ProvkVersion> findAllByProvkId(Long provkId);

    boolean existsByProvkId(Long provkId);

    @Query("SELECT coalesce(max(pv.version), 0) FROM ProvkVersion pv WHERE pv.provk.id = :provkId")
    int getMaxVersion(@Param("provkId") Long provkId);

    ProvkVersion findByProvkIdAndVersion(Long provkId, int version);

}
