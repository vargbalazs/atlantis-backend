package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostCenterDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostCenterMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costcenter")
public class CostCenterResource extends ExceptionHandling {
    private CostCenterService costCenterService;
    private CostCenterMapper costCenterMapper;

    public CostCenterResource(CostCenterService costCenterService, CostCenterMapper costCenterMapper) {
        this.costCenterService = costCenterService;
        this.costCenterMapper = costCenterMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostCenterDto>> getCostCenters() {
        List<CostCenterDto> costCenterDtos =
                costCenterMapper.toListDto(costCenterService.getAll());
        return new ResponseEntity<>(costCenterDtos, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CostCenterDto>> getFilteredCostCenters(@RequestParam(name = "plantId") Long plantId,
                                                                      @RequestParam(name = "year") int year) {
        List<CostCenterDto> costCenterDtos =
                costCenterMapper.toListDto(costCenterService.getCostCenters(plantId, year));
        return new ResponseEntity<>(costCenterDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostCenter(@Validated(New.class) @RequestBody CostCenterDto costCenterDto) {
        Long newId = costCenterService.addNew(costCenterMapper.toEntity(costCenterDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostCenter(@Validated(Existing.class) @RequestBody CostCenterDto costCenterDto) {
        CostCenter costCenter = costCenterMapper.toEntity(costCenterDto);
        costCenterService.update(costCenter);
        return new ResponseEntity<>(costCenter.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostCenter(@PathVariable("id") Long id) {
        costCenterService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
