package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.repository.impl.sp.CapPlanningItemPerCapGroupImpl;
import api.atlantis.service.interfaces.sp.CapPlanningItemPerCapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CapPlanningItemPerCapGroupServiceImpl implements CapPlanningItemPerCapGroupService {
    private CapPlanningItemPerCapGroupImpl rep;

    public CapPlanningItemPerCapGroupServiceImpl(CapPlanningItemPerCapGroupImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<CapPlanningItemPerCapGroup> getCapPlanningItems(Long companyId, Long plantId, int year, Long costAccTypeId) {
        return rep.getCapPlanningItems(companyId, plantId, year, costAccTypeId);
    }
}
