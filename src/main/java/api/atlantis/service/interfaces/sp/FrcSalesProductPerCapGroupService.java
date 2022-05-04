package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;

import java.util.List;

public interface FrcSalesProductPerCapGroupService {
    List<FrcSalesProductPerCapGroup> getFrcSalesProducts(Long frcId, int year, Long plantId);
}
