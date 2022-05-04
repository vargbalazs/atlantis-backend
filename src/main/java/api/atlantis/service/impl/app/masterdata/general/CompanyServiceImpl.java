package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.repository.interfaces.app.masterdata.general.CompanyRepository;
import api.atlantis.service.interfaces.app.masterdata.general.CompanyService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Long addNew(Company company) {
        companyRepository.save(company);
        return company.getId();
    }

    @Override
    public Long update(Company company) {
        Company updatedCompany = companyRepository.getById(company.getId());
        updatedCompany.setName(company.getName());
        updatedCompany.setShortName((company.getShortName()));
        companyRepository.save(updatedCompany);
        return updatedCompany.getId();
    }

    @Override
    public Long delete(Long id) {
        companyRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
