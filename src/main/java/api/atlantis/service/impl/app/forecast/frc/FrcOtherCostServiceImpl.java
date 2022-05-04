package api.atlantis.service.impl.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcOtherCost;
import api.atlantis.repository.interfaces.app.forecast.frc.FrcOtherCostRepository;
import api.atlantis.service.interfaces.app.forecast.frc.FrcOtherCostService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcOtherCostServiceImpl implements FrcOtherCostService {
    private FrcOtherCostRepository frcOtherCostRepository;

    public FrcOtherCostServiceImpl(FrcOtherCostRepository frcOtherCostRepository) {
        this.frcOtherCostRepository = frcOtherCostRepository;
    }

    @Override
    public Long addNew(FrcOtherCost entity) {
        frcOtherCostRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(FrcOtherCost entity) {
        FrcOtherCost frcOtherCost = frcOtherCostRepository.getById(entity.getId());
        frcOtherCost.setFrc(entity.getFrc());
        frcOtherCost.setCostAccount(entity.getCostAccount());
        frcOtherCost.setCostCenter(entity.getCostCenter());
        frcOtherCost.setCostEffect(entity.getCostEffect());
        frcOtherCost.setP1(entity.getP1());
        frcOtherCost.setP2(entity.getP2());
        frcOtherCost.setP3(entity.getP3());
        frcOtherCost.setP4(entity.getP4());
        frcOtherCost.setP5(entity.getP5());
        frcOtherCost.setP6(entity.getP6());
        frcOtherCost.setP7(entity.getP7());
        frcOtherCost.setP8(entity.getP8());
        frcOtherCost.setP9(entity.getP9());
        frcOtherCost.setP10(entity.getP10());
        frcOtherCost.setP11(entity.getP11());
        frcOtherCost.setP12(entity.getP12());
        frcOtherCostRepository.save(frcOtherCost);
        return frcOtherCost.getId();
    }

    @Override
    public Long delete(Long id) {
        frcOtherCostRepository.deleteById(id);
        return id;
    }

    @Override
    public List<FrcOtherCost> getAll() {
        return null;
    }

    @Override
    public List<FrcOtherCost> getFrcCosts(Long frcId) {
        return frcOtherCostRepository.getFrcOtherCostByFrcId(frcId);
    }

    @Override
    public void saveAll(List<FrcOtherCost> frcOtherCosts) {
        frcOtherCostRepository.saveAll(frcOtherCosts);
    }
}
