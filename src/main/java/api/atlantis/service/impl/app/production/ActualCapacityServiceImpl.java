package api.atlantis.service.impl.app.production;

import api.atlantis.domain.app.production.ActualCapacity;
import api.atlantis.repository.interfaces.app.production.ActualCapacityRepository;
import api.atlantis.service.interfaces.app.production.ActualCapacityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActualCapacityServiceImpl implements ActualCapacityService {
    private ActualCapacityRepository actualCapacityRepository;

    public ActualCapacityServiceImpl(ActualCapacityRepository actualCapacityRepository) {
        this.actualCapacityRepository = actualCapacityRepository;
    }

    @Override
    public Long addNew(ActualCapacity entity) {
        return null;
    }

    @Override
    public Long update(ActualCapacity entity) {
        actualCapacityRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<ActualCapacity> getAll() {
        return null;
    }
}
