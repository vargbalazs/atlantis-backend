package api.atlantis.resource.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.Frc;
import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcDto;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkDto;
import api.atlantis.mapstruct.dto.app.masterdata.general.CompanyDto;
import api.atlantis.mapstruct.mappers.app.forecast.frc.FrcMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.frc.FrcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/frc")
public class FrcResource extends ExceptionHandling {
    private FrcService frcService;
    private FrcMapper frcMapper;

    public FrcResource(FrcService frcService, FrcMapper frcMapper) {
        this.frcService = frcService;
        this.frcMapper = frcMapper;
    }

    @GetMapping()
    public ResponseEntity<List<FrcDto>> getFrcs(@RequestParam(name = "companyId") Long companyId,
                                                    @RequestParam(name = "plantId") Long plantId,
                                                    @RequestParam(name = "year") int year,
                                                    @RequestParam(name = "costAccTypeId") Long costAccTypeId) {
        List<FrcDto> frcDtos =
                frcMapper.toListDto(frcService.getFrcs(companyId, plantId, year, costAccTypeId));
        return new ResponseEntity<>(frcDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewFrc(@Validated(New.class) @RequestBody FrcDto frcDto) {
        Long newId = frcService.addNew(frcMapper.toEntity(frcDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateFrc(@Validated(Existing.class) @RequestBody FrcDto frcDto) {
        Frc frc = frcMapper.toEntity(frcDto);
        frcService.update(frc);
        return new ResponseEntity<>(frc.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteFrc(@PathVariable("id") Long id) {
        frcService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
