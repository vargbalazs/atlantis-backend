package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.ProvkDetailPerCapGroup;

import java.util.List;

public interface ProvkDetailPerCapGroupService {
    List<ProvkDetailPerCapGroup> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId, Long plantId);
}
