package api.atlantis.repository.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrcCapacityRepository extends JpaRepository<FrcCapacity, Long> {
}
