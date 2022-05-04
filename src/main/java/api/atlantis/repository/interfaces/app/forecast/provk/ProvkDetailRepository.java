package api.atlantis.repository.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvkDetailRepository extends JpaRepository<ProvkDetail, Long> {
}
