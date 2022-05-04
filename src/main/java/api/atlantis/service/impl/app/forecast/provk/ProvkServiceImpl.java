package api.atlantis.service.impl.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.repository.interfaces.app.forecast.provk.ProvkRepository;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvkServiceImpl implements ProvkService {
    private ProvkRepository provkRepository;

    public ProvkServiceImpl(ProvkRepository provkRepository) {
        this.provkRepository = provkRepository;
    }

    @Override
    public Long addNew(Provk entity) {
        provkRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(Provk entity) {
        Provk updatedProvk = provkRepository.getById(entity.getId());
        updatedProvk.setCompany(entity.getCompany());
        updatedProvk.setMonth(entity.getMonth());
        updatedProvk.setPeriod(entity.getPeriod());
        updatedProvk.setPlant(entity.getPlant());
        updatedProvk.setVersions(entity.getVersions());
        updatedProvk.setYear(entity.getYear());
        provkRepository.save(updatedProvk);
        return updatedProvk.getId();
    }

    @Override
    public Long delete(Long id) {
        provkRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Provk> getAll() {
        return null;
    }

    @Override
    public List<Provk> getProvks(Long companyId, Long plantId, int year) {
        return provkRepository.findAllByCompanyIdAndPlantIdAndYear(companyId, plantId, year);
    }

    @Override
    public boolean monthAlreadyExists(Long plantId, int year, int month) {
        Provk provk = provkRepository.findByPlantIdAndYearAndMonth(plantId, year, month);
        return provk != null;
    }
}
