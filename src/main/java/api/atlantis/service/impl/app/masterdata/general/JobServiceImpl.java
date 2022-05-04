package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Job;
import api.atlantis.repository.interfaces.app.masterdata.general.JobRepository;
import api.atlantis.service.interfaces.app.masterdata.general.JobService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Long addNew(Job job) {
        jobRepository.save(job);
        return job.getId();
    }

    @Override
    public Long update(Job job) {
        Job updatedJob = jobRepository.getById(job.getId());
        updatedJob.setName(job.getName());
        updatedJob.setDepartment(job.getDepartment());
        updatedJob.setDescr(job.getDescr());
        jobRepository.save(updatedJob);
        return updatedJob.getId();
    }

    @Override
    public Long delete(Long id) {
        jobRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }
}
