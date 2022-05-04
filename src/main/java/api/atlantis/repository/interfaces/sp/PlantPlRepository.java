package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.PlantPl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantPlRepository {
    List<PlantPl> getPlantPl(int year, int month, Long costAccTypeId, Long plantId, Long companyId);
}
