package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAllocationDetailDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostAllocationDetailMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAllocationDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costallocationdetails")
public class CostAllocationDetailResource extends ExceptionHandling {
    private CostAllocationDetailService costAllocationDetailService;
    private CostAllocationDetailMapper costAllocationDetailMapper;

    public CostAllocationDetailResource(CostAllocationDetailService costAllocationDetailService,
                                        CostAllocationDetailMapper costAllocationDetailMapper)
    {
        this.costAllocationDetailService = costAllocationDetailService;
        this.costAllocationDetailMapper = costAllocationDetailMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CostAllocationDetailDto>> getCostAllocDetails(@PathVariable("id") Long id) {
        List<CostAllocationDetailDto> costAllocationDetailDtos =
                costAllocationDetailMapper.toListDto(costAllocationDetailService.getDetailsByAllocId(id));
        return new ResponseEntity<>(costAllocationDetailDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveCostAllocDetails(
            @Validated(New.class) @RequestBody List<CostAllocationDetailDto> costAllocationDetailDtos) {
        costAllocationDetailService.saveAll(costAllocationDetailMapper.toListEntity(costAllocationDetailDtos));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Long> deleteCostAllocDetails(@PathVariable("id") Long id) {
        costAllocationDetailService.deleteByCostAllocationId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
