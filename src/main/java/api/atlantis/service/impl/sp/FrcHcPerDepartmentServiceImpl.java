package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.FrcHcPerDepartment;
import api.atlantis.repository.impl.sp.FrcHcPerDepartmentImpl;
import api.atlantis.repository.interfaces.sp.FrcHcPerDepartmentRepository;
import api.atlantis.service.interfaces.sp.FrcHcPerDepartmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrcHcPerDepartmentServiceImpl implements FrcHcPerDepartmentService {
    private FrcHcPerDepartmentImpl rep;

    public FrcHcPerDepartmentServiceImpl(FrcHcPerDepartmentImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<FrcHcPerDepartment> getFrcHc(Long frcId, Long departmentId, Long costAccTypeId, Long plantId, int year) {
        return rep.getFrcHc(frcId, departmentId, costAccTypeId, plantId, year);
    }
}
