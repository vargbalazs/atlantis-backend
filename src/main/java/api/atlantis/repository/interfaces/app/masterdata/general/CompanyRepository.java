package api.atlantis.repository.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
