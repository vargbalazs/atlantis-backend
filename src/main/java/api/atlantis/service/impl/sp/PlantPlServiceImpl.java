package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.PlantPl;
import api.atlantis.repository.impl.sp.PlantPlImpl;
import api.atlantis.service.interfaces.sp.PlantPlService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlantPlServiceImpl implements PlantPlService {
    private PlantPlImpl rep;

    public PlantPlServiceImpl(PlantPlImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<PlantPl> getPlantPl(int year, int month, Long costAccTypeId, Long plantId, Long companyId) {
        return rep.getPlantPl(year, month, costAccTypeId, plantId, companyId);
    }
}
