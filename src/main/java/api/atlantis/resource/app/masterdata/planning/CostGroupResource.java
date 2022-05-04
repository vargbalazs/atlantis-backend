package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostGroupDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostGroupMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costgroup")
public class CostGroupResource extends ExceptionHandling {
    private CostGroupService costGroupService;
    private CostGroupMapper costGroupMapper;

    public CostGroupResource(CostGroupService costGroupService, CostGroupMapper costGroupMapper) {
        this.costGroupService = costGroupService;
        this.costGroupMapper = costGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostGroupDto>> getCostGroups() {
        List<CostGroupDto> costGroupDtos =
                costGroupMapper.toListDto(costGroupService.getAll());
        return new ResponseEntity<>(costGroupDtos, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CostGroupDto>> getFilteredCostGroups(@RequestParam(name = "companyId") Long companyId) {
        List<CostGroupDto> costGroupDtos = costGroupMapper.toListDto(costGroupService.getCostGroups(companyId));
        return new ResponseEntity<>(costGroupDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostGroup(@Validated(New.class) @RequestBody CostGroupDto costGroupDto) {
        Long newId = costGroupService.addNew(costGroupMapper.toEntity(costGroupDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostGroup(@Validated(Existing.class) @RequestBody CostGroupDto costGroupDto) {
        CostGroup costGroup = costGroupMapper.toEntity(costGroupDto);
        costGroupService.update(costGroup);
        return new ResponseEntity<>(costGroup.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostGroup(@PathVariable("id") Long id) {
        costGroupService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
