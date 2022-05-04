package api.atlantis.service.impl.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapType;
import api.atlantis.repository.interfaces.app.masterdata.production.CapTypeRepository;
import api.atlantis.service.interfaces.app.masterdata.production.CapTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CapTypeServiceImpl implements CapTypeService {
    private CapTypeRepository capTypeRepository;

    public CapTypeServiceImpl(CapTypeRepository capTypeRepository) {
        this.capTypeRepository = capTypeRepository;
    }

    @Override
    public Long addNew(CapType entity) {
        capTypeRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CapType entity) {
        CapType updatedCapType = capTypeRepository.getById(entity.getId());
        updatedCapType.setCapType(entity.getCapType());
        updatedCapType.setCompany(entity.getCompany());
        updatedCapType.setPlant(entity.getPlant());
        capTypeRepository.save(updatedCapType);
        return updatedCapType.getId();
    }

    @Override
    public Long delete(Long id) {
        capTypeRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CapType> getAll() {
        return capTypeRepository.findAll();
    }

    @Override
    public List<CapType> getCapTypesByPlantId(Long plantId) {
        return capTypeRepository.findCapTypesByPlantId(plantId);
    }
}
