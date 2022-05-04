package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountingTypeDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostAccountingTypeMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAccountingTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costacctype")
public class CostAccountingTypeResource extends ExceptionHandling {
    private CostAccountingTypeService costAccountingTypeService;
    private CostAccountingTypeMapper costAccountingTypeMapper;

    public CostAccountingTypeResource(CostAccountingTypeService costAccountingTypeService,
                                      CostAccountingTypeMapper costAccountingTypeMapper) {
        this.costAccountingTypeService = costAccountingTypeService;
        this.costAccountingTypeMapper = costAccountingTypeMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostAccountingTypeDto>> getCostAccTypes() {
        List<CostAccountingTypeDto> costAccountingTypeDtos =
                costAccountingTypeMapper.toListDto(costAccountingTypeService.getAll());
        return new ResponseEntity<>(costAccountingTypeDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostAccType(@Validated(New.class) @RequestBody CostAccountingTypeDto costAccTypeDto) {
        Long newId = costAccountingTypeService.addNew(costAccountingTypeMapper.toEntity(costAccTypeDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostAccType(@Validated(Existing.class) @RequestBody CostAccountingTypeDto costAccTypeDto) {
        CostAccountingType costAccountingType = costAccountingTypeMapper.toEntity(costAccTypeDto);
        costAccountingTypeService.update(costAccountingType);
        return new ResponseEntity<>(costAccountingType.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostAccType(@PathVariable("id") Long id) {
        costAccountingTypeService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
