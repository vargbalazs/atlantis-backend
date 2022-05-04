package api.atlantis.service.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkDetail;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface ProvkDetailService extends BaseCrudService<ProvkDetail> {
    List<ProvkDetail> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId);
    void saveAll(List<ProvkDetail> provkDetails);
}
