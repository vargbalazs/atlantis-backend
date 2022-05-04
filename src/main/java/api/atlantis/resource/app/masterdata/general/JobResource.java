package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Job;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.JobDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.JobMapper;
import api.atlantis.service.interfaces.app.masterdata.general.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/general/job")
public class JobResource extends ExceptionHandling {
    private JobService jobService;
    private JobMapper jobMapper;

    public JobResource(JobService jobService, JobMapper jobMapper) {
        this.jobService = jobService;
        this.jobMapper = jobMapper;
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getJobs() {
        return new ResponseEntity<>(jobMapper.toListDto(jobService.getAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewJob(@RequestBody JobDto jobDto) {
        Long newId = jobService.addNew(jobMapper.toEntity(jobDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateJob(@RequestBody JobDto jobDto) {
        Job job = jobMapper.toEntity(jobDto);
        jobService.update(job);
        return new ResponseEntity<>(job.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteJob(@PathVariable("id") Long id) {
        jobService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
