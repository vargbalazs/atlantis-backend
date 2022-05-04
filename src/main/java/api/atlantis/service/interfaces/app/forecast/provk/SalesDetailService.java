package api.atlantis.service.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.SalesDetail;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface SalesDetailService extends BaseCrudService<SalesDetail> {
    List<SalesDetail> getSalesDetails(Long provkId, int year, int month, int version);
    void saveAll(List<SalesDetail> salesDetails);
}
