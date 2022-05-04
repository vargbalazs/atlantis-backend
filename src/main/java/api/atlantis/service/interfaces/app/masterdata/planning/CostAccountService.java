package api.atlantis.service.interfaces.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface CostAccountService extends BaseCrudService<CostAccount> {
    List<CostAccount> getCostAccounts(Long companyId, int year);
}
