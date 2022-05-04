package api.atlantis.service.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface ProvkService extends BaseCrudService<Provk> {
    List<Provk> getProvks(Long companyId, Long plantId, int year);
    boolean monthAlreadyExists(Long plantId, int year, int month);
}
