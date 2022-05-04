package api.atlantis.resource.app.forecast.frc;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import api.atlantis.domain.sp.FrcHcPerDepartment;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcHcDto;
import api.atlantis.mapstruct.dto.sp.FrcCapacityPerCapGroupDto;
import api.atlantis.mapstruct.dto.sp.FrcHcPerDepartmentDto;
import api.atlantis.mapstruct.mappers.app.forecast.frc.FrcHcMapper;
import api.atlantis.mapstruct.mappers.sp.FrcHcPerDepartmentMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.frc.FrcHcService;
import api.atlantis.service.interfaces.sp.FrcHcPerDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/frc/hc")
public class FrcHcResource extends ExceptionHandling {
    private FrcHcService frcHcService;
    private FrcHcPerDepartmentService frcHcPerDepartmentService;
    private FrcHcMapper frcHcMapper;
    private FrcHcPerDepartmentMapper frcHcPerDepartmentMapper;

    public FrcHcResource(FrcHcService frcHcService, FrcHcPerDepartmentService frcHcPerDepartmentService,
                         FrcHcMapper frcHcMapper, FrcHcPerDepartmentMapper frcHcPerDepartmentMapper) {
        this.frcHcService = frcHcService;
        this.frcHcPerDepartmentService = frcHcPerDepartmentService;
        this.frcHcMapper = frcHcMapper;
        this.frcHcPerDepartmentMapper = frcHcPerDepartmentMapper;
    }

    @GetMapping
    public ResponseEntity<List<FrcHcPerDepartmentDto>> getFrcHc(
            @RequestParam(name = "frcId") Long frcId,
            @RequestParam(name = "depId") Long depId,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId,
            @RequestParam(name = "plantId") Long plantId,
            @RequestParam(name = "year") int year) {
        List<FrcHcPerDepartment> frcHcPerDepartments =
                frcHcPerDepartmentService.getFrcHc(frcId, depId, costAccTypeId, plantId, year);
        return new ResponseEntity<>(frcHcPerDepartmentMapper.toListDto(frcHcPerDepartments), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveFrcHc(@Validated(New.class) @RequestBody FrcHcDto frcHcDto) {
        Long id = frcHcService.update(frcHcMapper.toEntity(frcHcDto));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
