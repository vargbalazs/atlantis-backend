package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Department;
import api.atlantis.repository.interfaces.app.masterdata.general.DepartmentRepository;
import api.atlantis.service.interfaces.app.masterdata.general.DepartmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository depRepository;

    public DepartmentServiceImpl(DepartmentRepository depRepository) {
        this.depRepository = depRepository;
    }

    @Override
    public Long addNew(Department dep) {
        depRepository.save(dep);
        return dep.getId();
    }

    @Override
    public Long update(Department dep) {
        Department updatedDepartment = depRepository.getById(dep.getId());
        updatedDepartment.setName(dep.getName());
        updatedDepartment.setPlant(dep.getPlant());
        depRepository.save(updatedDepartment);
        return updatedDepartment.getId();
    }

    @Override
    public Long delete(Long id) {
        depRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Department> getAll() {
        return depRepository.findAll();
    }

    @Override
    public List<Department> getDepartments(Long plantId) {
        return depRepository.findByPlantId(plantId);
    }
}
