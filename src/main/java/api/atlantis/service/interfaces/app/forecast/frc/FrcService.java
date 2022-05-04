package api.atlantis.service.interfaces.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.Frc;
import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface FrcService extends BaseCrudService<Frc> {
    List<Frc> getFrcs(Long companyId, Long plantId, int year, Long costAccTypeId);
}
