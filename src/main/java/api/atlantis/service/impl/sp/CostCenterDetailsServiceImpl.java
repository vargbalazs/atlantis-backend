package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.CostCenterDetails;
import api.atlantis.repository.impl.sp.CostCenterDetailsImpl;
import api.atlantis.service.interfaces.sp.CostCenterDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostCenterDetailsServiceImpl implements CostCenterDetailsService {
    private CostCenterDetailsImpl rep;

    public CostCenterDetailsServiceImpl(CostCenterDetailsImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<CostCenterDetails> getCostCenterDetails(int year, int month, Long costCenterId, Long costAccTypeId,
                                                        Long plantId, Long companyId) {
        return rep.getCostCenterDetails(year, month, costCenterId, costAccTypeId, plantId, companyId);
    }
}
