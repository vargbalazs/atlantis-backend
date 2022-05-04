package api.atlantis.repository.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcHc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrcHcRepository extends JpaRepository<FrcHc, Long> {
}
