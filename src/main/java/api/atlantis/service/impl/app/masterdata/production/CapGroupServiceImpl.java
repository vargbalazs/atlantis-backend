package api.atlantis.service.impl.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapGroup;
import api.atlantis.repository.interfaces.app.masterdata.production.CapGroupRepository;
import api.atlantis.service.interfaces.app.masterdata.production.CapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CapGroupServiceImpl implements CapGroupService {
    private CapGroupRepository capGroupRepository;

    public CapGroupServiceImpl(CapGroupRepository capGroupRepository) {
        this.capGroupRepository = capGroupRepository;
    }

    @Override
    public Long addNew(CapGroup entity) {
        capGroupRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CapGroup entity) {
        CapGroup updatedCapGroup = capGroupRepository.getById(entity.getId());
        updatedCapGroup.setCapGroup(entity.getCapGroup());
        updatedCapGroup.setCapName(entity.getCapName());
        updatedCapGroup.setCapType(entity.getCapType());
        updatedCapGroup.setCapUnit(entity.getCapUnit());
        updatedCapGroup.setCapYear(entity.getCapYear());
        updatedCapGroup.setCompany(entity.getCompany());
        updatedCapGroup.setFixRate(entity.getFixRate());
        updatedCapGroup.setInvNr(entity.getInvNr());
        updatedCapGroup.setNormalCap(entity.getNormalCap());
        updatedCapGroup.setPlant(entity.getPlant());
        updatedCapGroup.setUnit(entity.getUnit());
        capGroupRepository.save(updatedCapGroup);
        return updatedCapGroup.getId();
    }

    @Override
    public Long delete(Long id) {
        capGroupRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CapGroup> getAll() {
        return capGroupRepository.findAll();
    }
}
