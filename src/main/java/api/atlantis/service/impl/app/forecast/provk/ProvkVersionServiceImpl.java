package api.atlantis.service.impl.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.domain.app.forecast.provk.ProvkVersion;
import api.atlantis.repository.interfaces.app.forecast.provk.ProvkRepository;
import api.atlantis.repository.interfaces.app.forecast.provk.ProvkVersionRepository;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkVersionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvkVersionServiceImpl implements ProvkVersionService {
    private ProvkVersionRepository provkVersionRepository;
    private ProvkRepository provkRepository;

    public ProvkVersionServiceImpl(ProvkVersionRepository provkVersionRepository, ProvkRepository provkRepository) {
        this.provkVersionRepository = provkVersionRepository;
        this.provkRepository = provkRepository;
    }

    @Override
    public Long addNew(ProvkVersion entity) {
        provkVersionRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(ProvkVersion entity) {
        ProvkVersion updatedProvkVersion = provkVersionRepository.getById(entity.getId());
        updatedProvkVersion.setBa(entity.getBa());
        return updatedProvkVersion.getId();
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<ProvkVersion> getAll() {
        return null;
    }

    @Override
    public List<ProvkVersion> getProvkVersions(Long provkId) {
        return provkVersionRepository.findAllByProvkId(provkId);
    }

    @Override
    public boolean hasVersions(Long provkId) {
        return provkVersionRepository.existsByProvkId(provkId);
    }

    @Override
    public int getNextVersionNumber(Long provkId) {
        Provk provk = provkRepository.getById(provkId);
        int nextVersionNumber = provkVersionRepository.getMaxVersion(provkId) + 1;
        return nextVersionNumber > provk.getVersions() ? -1 : nextVersionNumber;
    }

    @Override
    public ProvkVersion getByProvkIdAndVersion(Long provkId, int version) {
        return provkVersionRepository.findByProvkIdAndVersion(provkId, version);
    }
}
