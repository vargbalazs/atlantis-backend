package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.CapPlanningItem;
import api.atlantis.repository.interfaces.app.planning.CapPlanningItemRepository;
import api.atlantis.service.interfaces.app.planning.CapPlanningItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CapPlanningItemServiceImpl implements CapPlanningItemService {
    private CapPlanningItemRepository capPlanningItemRepository;

    public CapPlanningItemServiceImpl(CapPlanningItemRepository capPlanningItemRepository) {
        this.capPlanningItemRepository = capPlanningItemRepository;
    }

    @Override
    public Long addNew(CapPlanningItem entity) {
        return null;
    }

    @Override
    public Long update(CapPlanningItem entity) {
        capPlanningItemRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<CapPlanningItem> getAll() {
        return null;
    }

}
