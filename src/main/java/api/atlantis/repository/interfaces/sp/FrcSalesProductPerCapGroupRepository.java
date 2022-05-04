package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrcSalesProductPerCapGroupRepository {
    List<FrcSalesProductPerCapGroup> getFrcSalesProducts(Long frcId, int year, Long plantId);
}
