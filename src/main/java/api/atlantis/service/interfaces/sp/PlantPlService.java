package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.PlantPl;

import java.util.List;

public interface PlantPlService {
    List<PlantPl> getPlantPl(int year, int month, Long costAccTypeId, Long plantId, Long companyId);
}
