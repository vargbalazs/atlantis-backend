package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.ProvkDetailPerCapGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvkDetailPerCapGroupRepository {
    List<ProvkDetailPerCapGroup> getProvkDetails(Long provkId, int year, int month, int version, Long capTypeId, Long plantId);
}
