package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostResp;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostRespDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostRespMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostRespService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costresp")
public class CostRespResource extends ExceptionHandling {
    private CostRespService costRespService;
    private CostRespMapper costRespMapper;

    public CostRespResource(CostRespService costRespService, CostRespMapper costRespMapper) {
        this.costRespService = costRespService;
        this.costRespMapper = costRespMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostRespDto>> getCostResp() {
        List<CostRespDto> costRespDtos =
                costRespMapper.toListDto(costRespService.getAll());
        return new ResponseEntity<>(costRespDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostResp(@Validated(New.class) @RequestBody CostRespDto costRespDto) {
        Long newId = costRespService.addNew(costRespMapper.toEntity(costRespDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostResp(@Validated(Existing.class) @RequestBody CostRespDto costRespDto) {
        CostResp costResp = costRespMapper.toEntity(costRespDto);
        costRespService.update(costResp);
        return new ResponseEntity<>(costResp.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostGroup(@PathVariable("id") Long id) {
        costRespService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
