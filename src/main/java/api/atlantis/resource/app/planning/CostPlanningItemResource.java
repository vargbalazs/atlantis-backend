package api.atlantis.resource.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import api.atlantis.domain.app.planning.Version;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.planning.CostPlanningItemDto;
import api.atlantis.mapstruct.dto.app.planning.TaskDto;
import api.atlantis.mapstruct.dto.app.planning.VersionDto;
import api.atlantis.mapstruct.mappers.app.planning.CostPlanningItemMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.planning.CostPlanningItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/planning/costplanning")
public class CostPlanningItemResource extends ExceptionHandling {
    private CostPlanningItemService costPlanningItemService;
    private CostPlanningItemMapper costPlanningItemMapper;

    public CostPlanningItemResource(CostPlanningItemService costPlanningItemService,
                                    CostPlanningItemMapper costPlanningItemMapper) {
        this.costPlanningItemService = costPlanningItemService;
        this.costPlanningItemMapper = costPlanningItemMapper;
    }

    @GetMapping("/items")
    public ResponseEntity<List<CostPlanningItemDto>> getCostPlanningItems(
            @RequestParam(name = "costCenterId") Long costCenterId,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId) {
        List<CostPlanningItemDto> costPlanningItemDtos =
                costPlanningItemMapper.toListDto(costPlanningItemService.getPlanningItems(costCenterId, costAccTypeId));
        return new ResponseEntity<>(costPlanningItemDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewPlanningItem(@Validated(New.class) @RequestBody CostPlanningItemDto costPlanningItemDto) {
        Long newId = costPlanningItemService.addNew(costPlanningItemMapper.toEntity(costPlanningItemDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updatePlanningItem(@Validated(Existing.class) @RequestBody CostPlanningItemDto costPlanningItemDto) {
        CostPlanningItem costPlanningItem = costPlanningItemMapper.toEntity(costPlanningItemDto);
        costPlanningItemService.update(costPlanningItem);
        return new ResponseEntity<>(costPlanningItem.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deletePlanningItem(@PathVariable("id") Long id) {
        costPlanningItemService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
