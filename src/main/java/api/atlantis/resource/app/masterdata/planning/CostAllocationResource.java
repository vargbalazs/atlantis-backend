package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocation;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAllocationDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostAllocationMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costallocation")
public class CostAllocationResource extends ExceptionHandling {
    private CostAllocationService costAllocationService;
    private CostAllocationMapper  costAllocationMapper;

    public CostAllocationResource(CostAllocationService costAllocationService, CostAllocationMapper costAllocationMapper) {
        this.costAllocationService = costAllocationService;
        this.costAllocationMapper = costAllocationMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostAllocationDto>> getCostAllocations() {
        List<CostAllocationDto> costAllocationDtos =
                costAllocationMapper.toListDto(costAllocationService.getAll());
        return new ResponseEntity<>(costAllocationDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostAllocation(@Validated(New.class) @RequestBody CostAllocationDto costAllocationDto) {
        Long newId = costAllocationService.addNew(costAllocationMapper.toEntity(costAllocationDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostAllocation(@Validated(Existing.class) @RequestBody CostAllocationDto costAllocationDto) {
        CostAllocation costAllocation = costAllocationMapper.toEntity(costAllocationDto);
        costAllocationService.update(costAllocation);
        return new ResponseEntity<>(costAllocation.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostAllocation(@PathVariable("id") Long id) {
        costAllocationService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
