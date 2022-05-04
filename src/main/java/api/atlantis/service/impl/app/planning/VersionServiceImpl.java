package api.atlantis.service.impl.app.planning;

import api.atlantis.domain.app.planning.Version;
import api.atlantis.repository.interfaces.app.planning.VersionRepository;
import api.atlantis.service.interfaces.app.planning.VersionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {
    private VersionRepository versionRepository;

    public VersionServiceImpl(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    @Override
    public Long addNew(Version entity) {
        versionRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(Version entity) {
        Version updatedVersion = versionRepository.getById(entity.getId());
        updatedVersion.setCompany(entity.getCompany());
        updatedVersion.setPlant(entity.getPlant());
        updatedVersion.setYear(entity.getYear());
        updatedVersion.setDescr(entity.getDescr());
        updatedVersion.setCostAccType(entity.getCostAccType());
        updatedVersion.setStatus(entity.getStatus());
        versionRepository.save(updatedVersion);
        return updatedVersion.getId();
    }

    @Override
    public Long delete(Long id) {
        versionRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Version> getAll() {
        return versionRepository.findAll();
    }
}
