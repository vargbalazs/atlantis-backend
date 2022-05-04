package api.atlantis.service.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Department;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface DepartmentService extends BaseCrudService<Department> {
    List<Department> getDepartments(Long plantId);
}
