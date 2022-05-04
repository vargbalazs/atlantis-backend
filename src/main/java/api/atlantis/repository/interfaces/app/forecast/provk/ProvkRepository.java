package api.atlantis.repository.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvkRepository extends JpaRepository<Provk, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<Provk> findAllByCompanyIdAndPlantIdAndYear(Long companyId, Long plantId, int year);
    Provk findByPlantIdAndYearAndMonth(Long plantId, int year, int month);
}
