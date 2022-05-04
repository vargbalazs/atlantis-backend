package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.PlantArea;
import api.atlantis.repository.interfaces.app.masterdata.general.PlantAreaRepository;
import api.atlantis.service.interfaces.app.masterdata.general.PlantAreaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlantAreaServiceImpl implements PlantAreaService {
    private PlantAreaRepository plantAreaRepository;

    public PlantAreaServiceImpl(PlantAreaRepository plantAreaRepository) {
        this.plantAreaRepository = plantAreaRepository;
    }

    @Override
    public Long addNew(PlantArea plantArea) {
        plantAreaRepository.save(plantArea);
        return plantArea.getId();
    }

    @Override
    public Long update(PlantArea plantArea) {
        PlantArea updatedPlantArea = plantAreaRepository.getById(plantArea.getId());
        updatedPlantArea.setCode(plantArea.getCode());
        updatedPlantArea.setName(plantArea.getName());
        updatedPlantArea.setPlant(plantArea.getPlant());
        plantAreaRepository.save(updatedPlantArea);
        return updatedPlantArea.getId();
    }

    @Override
    public Long delete(Long id) {
        plantAreaRepository.deleteById(id);
        return id;
    }

    @Override
    public List<PlantArea> getAll() { return plantAreaRepository.findAll();}
}
