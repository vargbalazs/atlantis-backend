package api.atlantis.service.impl.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.Frc;
import api.atlantis.repository.interfaces.app.forecast.frc.FrcRepository;
import api.atlantis.service.interfaces.app.forecast.frc.FrcService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcServiceImpl implements FrcService {
    private FrcRepository frcRepository;

    public FrcServiceImpl(FrcRepository frcRepository) {
        this.frcRepository = frcRepository;
    }

    @Override
    public Long addNew(Frc entity) {
        frcRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(Frc entity) {
        Frc updatedFrc = frcRepository.getById(entity.getId());
        updatedFrc.setCompany(entity.getCompany());
        updatedFrc.setClosed(entity.isClosed());
        updatedFrc.setComment(entity.getComment());
        updatedFrc.setCostAccType(entity.getCostAccType());
        updatedFrc.setPlant(entity.getPlant());
        updatedFrc.setVersion(entity.getVersion());
        updatedFrc.setYear(entity.getYear());
        frcRepository.save(updatedFrc);
        return updatedFrc.getId();
    }

    @Override
    public Long delete(Long id) {
        frcRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Frc> getAll() {
        return null;
    }

    @Override
    public List<Frc> getFrcs(Long companyId, Long plantId, int year, Long costAccTypeId) {
        return frcRepository.getFrcs(companyId, plantId, year, costAccTypeId);
    }
}
