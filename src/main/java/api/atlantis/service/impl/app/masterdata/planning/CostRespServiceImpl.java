package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostResp;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostRespRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostRespService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostRespServiceImpl implements CostRespService {
    private CostRespRepository costRespRepository;

    public CostRespServiceImpl(CostRespRepository costRespRepository) {
        this.costRespRepository = costRespRepository;
    }

    @Override
    public Long addNew(CostResp entity) {
        costRespRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostResp entity) {
        CostResp updatedCostResp = costRespRepository.getById(entity.getId());
        updatedCostResp.setCompany(entity.getCompany());
        updatedCostResp.setCostCenter(entity.getCostCenter());
        updatedCostResp.setDepartment(entity.getDepartment());
        updatedCostResp.setName(entity.getName());
        updatedCostResp.setEmail(entity.getEmail());
        updatedCostResp.setJob(entity.getJob());
        updatedCostResp.setLang(entity.getLang());
        updatedCostResp.setPlant(entity.getPlant());
        costRespRepository.save(updatedCostResp);
        return updatedCostResp.getId();
    }

    @Override
    public Long delete(Long id) {
        costRespRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostResp> getAll() {
        return costRespRepository.findAll();
    }
}
