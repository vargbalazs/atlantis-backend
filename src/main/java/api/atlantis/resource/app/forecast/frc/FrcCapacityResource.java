package api.atlantis.resource.app.forecast.frc;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcCapacityDto;
import api.atlantis.mapstruct.dto.sp.FrcCapacityPerCapGroupDto;
import api.atlantis.mapstruct.mappers.app.forecast.frc.FrcCapacityMapper;
import api.atlantis.mapstruct.mappers.sp.FrcCapacityPerCapGroupMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.frc.FrcCapacityService;
import api.atlantis.service.interfaces.sp.FrcCapacityPerCapGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/frc/capacity")
public class FrcCapacityResource extends ExceptionHandling {
    private FrcCapacityService frcCapacityService;
    private FrcCapacityPerCapGroupService frcCapacityPerCapGroupService;
    private FrcCapacityMapper frcCapacityMapper;
    private FrcCapacityPerCapGroupMapper frcCapacityPerCapGroupMapper;

    public FrcCapacityResource(FrcCapacityService frcCapacityService,
                               FrcCapacityPerCapGroupService frcCapacityPerCapGroupService,
                               FrcCapacityMapper frcCapacityMapper,
                               FrcCapacityPerCapGroupMapper frcCapacityPerCapGroupMapper) {
        this.frcCapacityService = frcCapacityService;
        this.frcCapacityPerCapGroupService = frcCapacityPerCapGroupService;
        this.frcCapacityMapper = frcCapacityMapper;
        this.frcCapacityPerCapGroupMapper = frcCapacityPerCapGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<FrcCapacityPerCapGroupDto>> getFrcCapacities(
            @RequestParam(name = "frcId") Long frcId,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "plantId") Long plantId) {
        List<FrcCapacityPerCapGroup> frcCapacityPerCapGroups =
                frcCapacityPerCapGroupService.getFrcCapacities(frcId, year, plantId);
        return new ResponseEntity<>(frcCapacityPerCapGroupMapper.toListDto(frcCapacityPerCapGroups), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveFrcCapacity(@Validated(New.class) @RequestBody FrcCapacityDto frcCapacityDto) {
        Long id = frcCapacityService.update(frcCapacityMapper.toEntity(frcCapacityDto));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
