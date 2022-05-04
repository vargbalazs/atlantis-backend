package api.atlantis.resource.app.planning;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.planning.CapPlanningItemDto;
import api.atlantis.mapstruct.dto.sp.CapPlanningItemPerCapGroupDto;
import api.atlantis.mapstruct.mappers.app.planning.CapPlanningItemMapper;
import api.atlantis.mapstruct.mappers.sp.CapPlanningItemPerCapGroupMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.sp.CapPlanningItemPerCapGroupService;
import api.atlantis.service.interfaces.app.planning.CapPlanningItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/planning/capplanning")
public class CapPlanningItemResource extends ExceptionHandling {
    private CapPlanningItemService capPlanningItemService;
    private CapPlanningItemPerCapGroupService capPlanningItemPerCapGroupService;
    private CapPlanningItemMapper capPlanningItemMapper;
    private CapPlanningItemPerCapGroupMapper capPlanningItemPerCapGroupMapper;

    public CapPlanningItemResource(CapPlanningItemService capPlanningItemService,
                                   CapPlanningItemPerCapGroupService capPlanningItemPerCapGroupService,
                                   CapPlanningItemMapper capPlanningItemMapper,
                                   CapPlanningItemPerCapGroupMapper capPlanningItemPerCapGroupMapper) {
        this.capPlanningItemService = capPlanningItemService;
        this.capPlanningItemPerCapGroupService = capPlanningItemPerCapGroupService;
        this.capPlanningItemMapper = capPlanningItemMapper;
        this.capPlanningItemPerCapGroupMapper = capPlanningItemPerCapGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<CapPlanningItemPerCapGroupDto>> getPlanningItems(
            @RequestParam(name = "companyId") Long companyId,
            @RequestParam(name = "plantId") Long plantId,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId) {
        List<CapPlanningItemPerCapGroup> capPlanningItems =
                capPlanningItemPerCapGroupService.getCapPlanningItems(companyId, plantId, year, costAccTypeId);
        return new ResponseEntity<>(capPlanningItemPerCapGroupMapper.toListDto(capPlanningItems), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> savePlanningItems(@Validated(New.class) @RequestBody CapPlanningItemDto capPlanningItemDto) {
        capPlanningItemService.update(capPlanningItemMapper.toEntity(capPlanningItemDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
