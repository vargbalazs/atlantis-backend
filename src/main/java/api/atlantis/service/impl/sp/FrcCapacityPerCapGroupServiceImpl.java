package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import api.atlantis.repository.impl.sp.FrcCapacityPerCapGroupImpl;
import api.atlantis.service.interfaces.sp.FrcCapacityPerCapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcCapacityPerCapGroupServiceImpl implements FrcCapacityPerCapGroupService {
    private FrcCapacityPerCapGroupImpl rep;

    public FrcCapacityPerCapGroupServiceImpl(FrcCapacityPerCapGroupImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<FrcCapacityPerCapGroup> getFrcCapacities(Long frcId, int year, Long plantId) {
        return rep.getFrcCapacities(frcId, year, plantId);
    }
}
