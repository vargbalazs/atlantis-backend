package api.atlantis.service.impl.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcCapacity;
import api.atlantis.repository.interfaces.app.forecast.frc.FrcCapacityRepository;
import api.atlantis.service.interfaces.app.forecast.frc.FrcCapacityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcCapacityServiceImpl implements FrcCapacityService {
    private FrcCapacityRepository frcCapacityRepository;

    public FrcCapacityServiceImpl(FrcCapacityRepository frcCapacityRepository) {
        this.frcCapacityRepository = frcCapacityRepository;
    }

    @Override
    public Long addNew(FrcCapacity entity) {
        return null;
    }

    @Override
    public Long update(FrcCapacity entity) {
        frcCapacityRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<FrcCapacity> getAll() {
        return null;
    }
}
