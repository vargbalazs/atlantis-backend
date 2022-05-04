package api.atlantis.resource.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.domain.app.planning.JobCost;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.planning.HcPlanningItemDto;
import api.atlantis.mapstruct.dto.app.planning.JobCostDto;
import api.atlantis.mapstruct.mappers.app.planning.HcPlanningItemMapper;
import api.atlantis.mapstruct.mappers.app.planning.JobCostMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.planning.HcPlanningItemService;
import api.atlantis.service.interfaces.app.planning.JobCostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/planning/hcplanning")
public class HcPlanningItemResource extends ExceptionHandling {
    private HcPlanningItemService hcPlanningItemService;
    private HcPlanningItemMapper hcPlanningItemMapper;
    private JobCostService jobCostService;
    private JobCostMapper jobCostMapper;

    public HcPlanningItemResource(HcPlanningItemService hcPlanningItemService, HcPlanningItemMapper hcPlanningItemMapper,
                                  JobCostService jobCostService, JobCostMapper jobCostMapper) {
        this.hcPlanningItemService = hcPlanningItemService;
        this.hcPlanningItemMapper = hcPlanningItemMapper;
        this.jobCostService = jobCostService;
        this.jobCostMapper = jobCostMapper;
    }

    @GetMapping("/items")
    public ResponseEntity<List<HcPlanningItemDto>> getHcPlanningItems(
            @RequestParam(name = "costCenterId") Long costCenterId,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId){
        List<HcPlanningItemDto> hcPlanningItemDtos =
                hcPlanningItemMapper.toListDto(hcPlanningItemService.getPlanningItems(costCenterId, costAccTypeId));
        return new ResponseEntity<>(hcPlanningItemDtos, HttpStatus.OK);
    }

    @GetMapping("/costassign/{hcPlanningItemId}")
    public ResponseEntity<List<JobCostDto>> getJobCosts(@PathVariable("hcPlanningItemId") Long hcPlanningItemId) {
        List<JobCostDto> jobCostDtos = jobCostMapper.toListDto(jobCostService.getJobCosts(hcPlanningItemId));
        return new ResponseEntity<>(jobCostDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewPlanningItem(@Validated(New.class) @RequestBody HcPlanningItemDto hcPlanningItemDto) {
        Long newId = hcPlanningItemService.addNew(hcPlanningItemMapper.toEntity(hcPlanningItemDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PostMapping("/costassign/{hcPlanningItemId}")
    public ResponseEntity<Long> saveJobCosts(@Validated(New.class) @RequestBody List<JobCostDto> jobCostDtos,
                                             @PathVariable("hcPlanningItemId") Long hcPlanningItemId) {
        jobCostService.saveAll(jobCostMapper.toListEntity(jobCostDtos), hcPlanningItemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PatchMapping
    public ResponseEntity<Long> updatePlanningItem(@Validated(Existing.class) @RequestBody HcPlanningItemDto hcPlanningItemDto) {
        HcPlanningItem hcPlanningItem = hcPlanningItemMapper.toEntity(hcPlanningItemDto);
        hcPlanningItemService.update(hcPlanningItem);
        return new ResponseEntity<>(hcPlanningItem.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deletePlanningItem(@PathVariable("id") Long id) {
        hcPlanningItemService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
