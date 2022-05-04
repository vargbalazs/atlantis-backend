package api.atlantis.service.impl.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapUnit;
import api.atlantis.repository.interfaces.app.masterdata.production.CapUnitRepository;
import api.atlantis.service.interfaces.app.masterdata.production.CapUnitService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CapUnitServiceImpl implements CapUnitService {
    private CapUnitRepository capUnitRepository;

    public CapUnitServiceImpl(CapUnitRepository capUnitRepository) {
        this.capUnitRepository = capUnitRepository;
    }

    @Override
    public Long addNew(CapUnit entity) {
        capUnitRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CapUnit entity) {
        CapUnit updatedCapUnit = capUnitRepository.getById(entity.getId());
        updatedCapUnit.setUnit(entity.getUnit());
        updatedCapUnit.setCompany(entity.getCompany());
        updatedCapUnit.setName(entity.getName());
        updatedCapUnit.setPlant(entity.getPlant());
        capUnitRepository.save(updatedCapUnit);
        return updatedCapUnit.getId();
    }

    @Override
    public Long delete(Long id) {
        capUnitRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CapUnit> getAll() {
        return capUnitRepository.findAll();
    }
}
