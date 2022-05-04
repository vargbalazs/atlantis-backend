package api.atlantis.repository.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.Frc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrcRepository extends JpaRepository<Frc, Long> {
//  in this case we use the query annotation to avoid ugly long method names and to have custom repository implementations
    @Query("SELECT f FROM Frc f " +
            "LEFT JOIN FETCH f.costAccType LEFT JOIN FETCH f.company LEFT JOIN FETCH f.plant " +
            "WHERE f.company.id = :companyId AND f.plant.id = :plantId " +
            "AND f.year = :year AND f.costAccType.id = :costAccTypeId")
    List<Frc> getFrcs(@Param("companyId") Long companyId, @Param("plantId") Long plantId, @Param("year") int year,
                      @Param("costAccTypeId") Long costAccTypeId);
}
