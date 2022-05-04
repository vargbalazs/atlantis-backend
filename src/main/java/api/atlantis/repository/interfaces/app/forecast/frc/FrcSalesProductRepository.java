package api.atlantis.repository.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcSalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrcSalesProductRepository extends JpaRepository<FrcSalesProduct, Long> {
}
