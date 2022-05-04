package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.repository.interfaces.app.masterdata.general.PlantRepository;
import api.atlantis.service.interfaces.app.masterdata.general.PlantService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {
    private PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public Long addNew(Plant plant) {
        plantRepository.save(plant);
        return plant.getId();
    }

    @Override
    public Long update(Plant plant) {
        Plant updatedPlant = plantRepository.getById(plant.getId());
        updatedPlant.setCode(plant.getCode());
        updatedPlant.setLocation(plant.getLocation());
        updatedPlant.setCompany(plant.getCompany());
        plantRepository.save(updatedPlant);
        return updatedPlant.getId();
    }

    @Override
    public Long delete(Long id) {
        plantRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Plant> getAll() {
        return plantRepository.findAll();
    }
}
