package api.atlantis.repository.interfaces.app.production;

import api.atlantis.domain.app.production.ActualCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualCapacityRepository extends JpaRepository<ActualCapacity, Long> {
}
