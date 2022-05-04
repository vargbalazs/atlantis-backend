package api.atlantis.repository.interfaces.sp;

import api.atlantis.domain.sp.FrcHcPerDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrcHcPerDepartmentRepository {
    List<FrcHcPerDepartment> getFrcHc(Long frcId, Long departmentId, Long costAccTypeId, Long plantId, int year);
}
