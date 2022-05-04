package api.atlantis.service.interfaces.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapType;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CapTypeService extends BaseCrudService<CapType> {
    List<CapType> getCapTypesByPlantId(Long plantId);
}
