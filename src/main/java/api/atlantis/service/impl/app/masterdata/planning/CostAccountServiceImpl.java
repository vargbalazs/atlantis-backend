package api.atlantis.service.impl.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;
import api.atlantis.repository.interfaces.app.masterdata.planning.CostAccountRepository;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostAccountServiceImpl implements CostAccountService {
    private CostAccountRepository costAccountRepository;

    public CostAccountServiceImpl(CostAccountRepository costAccountRepository) {
        this.costAccountRepository = costAccountRepository;
    }

    @Override
    public Long addNew(CostAccount entity) {
        costAccountRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Long update(CostAccount entity) {
        CostAccount updatedCostAccount = costAccountRepository.getById(entity.getId());
        updatedCostAccount.setAccountNumber(entity.getAccountNumber());
        updatedCostAccount.setCompany(entity.getCompany());
        updatedCostAccount.setCostGroup(entity.getCostGroup());
        updatedCostAccount.setName(entity.getName());
        updatedCostAccount.setAccountNumber(entity.getAccountNumber());
        updatedCostAccount.setUsedForPersPlanning(entity.isUsedForPersPlanning());
        updatedCostAccount.setFixRate(entity.getFixRate());
        updatedCostAccount.setVarRate(entity.getVarRate());
        updatedCostAccount.setYear(entity.getYear());
        costAccountRepository.save(updatedCostAccount);
        return updatedCostAccount.getId();
    }

    @Override
    public Long delete(Long id) {
        costAccountRepository.deleteById(id);
        return id;
    }

    @Override
    public List<CostAccount> getAll() {
        return costAccountRepository.findAll();
    }

    @Override
    public List<CostAccount> getCostAccounts(Long companyId, int year) {
        return costAccountRepository.findByCompanyIdAndYear(companyId, year);
    }
}
