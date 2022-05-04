package api.atlantis.resource.app.production;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.production.ActualCapacityDto;
import api.atlantis.mapstruct.dto.sp.ActualCapacityPerCapGroupDto;
import api.atlantis.mapstruct.mappers.app.production.ActualCapacityMapper;
import api.atlantis.mapstruct.mappers.sp.ActualCapacityPerCapGroupMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.production.ActualCapacityService;
import api.atlantis.service.interfaces.sp.ActualCapacityPerCapGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/production/actualcap")
public class ActualCapacityResource extends ExceptionHandling {
    private ActualCapacityService actualCapacityService;
    private ActualCapacityPerCapGroupService actualCapacityPerCapGroupService;
    private ActualCapacityMapper actualCapacityMapper;
    private ActualCapacityPerCapGroupMapper actualCapacityPerCapGroupMapper;

    public ActualCapacityResource(ActualCapacityService actualCapacityService,
                                  ActualCapacityPerCapGroupService actualCapacityPerCapGroupService,
                                  ActualCapacityMapper actualCapacityMapper,
                                  ActualCapacityPerCapGroupMapper actualCapacityPerCapGroupMapper) {
        this.actualCapacityService = actualCapacityService;
        this.actualCapacityPerCapGroupService = actualCapacityPerCapGroupService;
        this.actualCapacityMapper = actualCapacityMapper;
        this.actualCapacityPerCapGroupMapper = actualCapacityPerCapGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<ActualCapacityPerCapGroupDto>> getActualCapacities(
            @RequestParam(name = "companyId") Long companyId,
            @RequestParam(name = "plantId") Long plantId,
            @RequestParam(name = "year") int year) {
        List<ActualCapacityPerCapGroup> actualCapacityPerCapGroups =
                actualCapacityPerCapGroupService.getActualCapacities(companyId, plantId, year);
        return new ResponseEntity<>(actualCapacityPerCapGroupMapper.toListDto(actualCapacityPerCapGroups), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveActualCapacity(@Validated(New.class) @RequestBody ActualCapacityDto actualCapacityDto) {
        actualCapacityService.update(actualCapacityMapper.toEntity(actualCapacityDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
