package api.atlantis.service.impl.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkDetail;
import api.atlantis.domain.app.forecast.provk.ProvkVersion;
import api.atlantis.repository.interfaces.app.forecast.provk.ProvkDetailRepository;
import api.atlantis.repository.interfaces.app.forecast.provk.ProvkVersionRepository;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkDetailService;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkVersionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvkDetailServiceImpl implements ProvkDetailService {
    private ProvkDetailRepository provkDetailRepository;
    private ProvkVersionService provkVersionService;

    public ProvkDetailServiceImpl(ProvkDetailRepository provkDetailRepository, ProvkVersionService provkVersionService) {
        this.provkDetailRepository = provkDetailRepository;
        this.provkVersionService = provkVersionService;
    }

    @Override
    public Long addNew(ProvkDetail entity) {
        return null;
    }

    @Override
    public void saveAll(List<ProvkDetail> provkDetails) {
        // get the provk version
        ProvkVersion provkVersion = provkVersionService.getByProvkIdAndVersion(provkDetails.get(0).getProvk().getId(),
                provkDetails.get(0).getVersion());
        // sum up the ba out of the provkDetails and update the ba in the provkVersion
        int ba = 0;
        for (ProvkDetail provkDetail : provkDetails) {
            ba += provkDetail.getBa();
        }
        // update the ba in the provk version
        provkVersion.setBa(ba);
        provkVersionService.update(provkVersion);
        this.provkDetailRepository.saveAll(provkDetails);
    }

    @Override
    public Long update(ProvkDetail entity) { return null; }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<ProvkDetail> getAll() {
        return null;
    }

    @Override
    public List<ProvkDetail> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId) {
        return null;
    }
}
