package api.atlantis.service.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcOtherCost;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface FrcOtherCostService extends BaseCrudService<FrcOtherCost> {
    List<FrcOtherCost> getFrcCosts(Long frcId);
    void saveAll(List<FrcOtherCost> frcOtherCosts);
}
