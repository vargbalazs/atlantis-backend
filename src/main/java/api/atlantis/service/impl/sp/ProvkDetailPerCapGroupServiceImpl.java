package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.ProvkDetailPerCapGroup;
import api.atlantis.repository.impl.sp.ProvkDetailPerCapGroupImpl;
import api.atlantis.service.interfaces.sp.ProvkDetailPerCapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvkDetailPerCapGroupServiceImpl implements ProvkDetailPerCapGroupService {
    private ProvkDetailPerCapGroupImpl rep;

    public ProvkDetailPerCapGroupServiceImpl(ProvkDetailPerCapGroupImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<ProvkDetailPerCapGroup> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId,
                                                        Long plantId) {
        return rep.getProvkDetails(provkId, year, month, version, capTypeId, plantId);
    }
}
