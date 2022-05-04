package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;
import api.atlantis.repository.impl.sp.ActualCapacityPerCapGroupImpl;
import api.atlantis.service.interfaces.sp.ActualCapacityPerCapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActualCapacityPerCapGroupServiceImpl implements ActualCapacityPerCapGroupService {
    private ActualCapacityPerCapGroupImpl rep;

    public ActualCapacityPerCapGroupServiceImpl(ActualCapacityPerCapGroupImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<ActualCapacityPerCapGroup> getActualCapacities(Long companyId, Long plantId, int year) {
        return rep.getActualCapacities(companyId, plantId, year);
    }
}
