package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;
import api.atlantis.repository.impl.sp.FrcSalesProductPerCapGroupImpl;
import api.atlantis.service.interfaces.sp.FrcSalesProductPerCapGroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrsSalesProductPerCapGroupServiceImpl implements FrcSalesProductPerCapGroupService {
    private FrcSalesProductPerCapGroupImpl rep;

    public FrsSalesProductPerCapGroupServiceImpl(FrcSalesProductPerCapGroupImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<FrcSalesProductPerCapGroup> getFrcSalesProducts(Long frcId, int year, Long plantId) {
        return rep.getFrcSalesProducts(frcId, year, plantId);
    }
}
