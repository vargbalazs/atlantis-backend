package api.atlantis.service.interfaces.sp;

import api.atlantis.domain.sp.FrcHcPerDepartment;

import java.util.List;

public interface FrcHcPerDepartmentService {
    List<FrcHcPerDepartment> getFrcHc(Long frcId, Long departmentId, Long costAccTypeId, Long plantId, int year);
}
