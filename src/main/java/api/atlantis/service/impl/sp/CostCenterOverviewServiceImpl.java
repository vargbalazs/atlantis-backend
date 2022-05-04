package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.CostCenterOverview;
import api.atlantis.repository.impl.sp.CostCenterOverviewImpl;
import api.atlantis.service.interfaces.sp.CostCenterOverviewService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostCenterOverviewServiceImpl implements CostCenterOverviewService {
    private CostCenterOverviewImpl rep;

    public CostCenterOverviewServiceImpl(CostCenterOverviewImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<CostCenterOverview> getCostCenterOverview(int year, int month, Long costAccTypeId, Long plantId) {
        return rep.getCostCenterOverview(year, month, costAccTypeId, plantId);
    }
}
