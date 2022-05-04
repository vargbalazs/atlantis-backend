package api.atlantis.service.impl.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcHc;
import api.atlantis.repository.interfaces.app.forecast.frc.FrcHcRepository;
import api.atlantis.service.interfaces.app.forecast.frc.FrcHcService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcHcServiceImpl implements FrcHcService {
    private FrcHcRepository frcHcRepository;

    public FrcHcServiceImpl(FrcHcRepository frcHcRepository) {
        this.frcHcRepository = frcHcRepository;
    }

    @Override
    public Long addNew(FrcHc entity) {
        return null;
    }

    @Override
    public Long update(FrcHc entity) {
        frcHcRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<FrcHc> getAll() {
        return null;
    }
}
