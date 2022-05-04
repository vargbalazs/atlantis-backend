package api.atlantis.resource.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapUnit;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapUnitDto;
import api.atlantis.mapstruct.mappers.app.masterdata.production.CapUnitMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.production.CapUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/production/capunit")
public class CapUnitResource extends ExceptionHandling {
    private CapUnitService capUnitService;
    private CapUnitMapper capUnitMapper;

    public CapUnitResource(CapUnitService capUnitService, CapUnitMapper capUnitMapper) {
        this.capUnitService = capUnitService;
        this.capUnitMapper = capUnitMapper;
    }

    @GetMapping
    public ResponseEntity<List<CapUnitDto>> getCapUnits() {
        List<CapUnitDto> capUnitDtos =
                capUnitMapper.toListDto(capUnitService.getAll());
        return new ResponseEntity<>(capUnitDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCapUnit(@Validated(New.class) @RequestBody CapUnitDto capUnitDto) {
        Long newId = capUnitService.addNew(capUnitMapper.toEntity(capUnitDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCapUnit(@Validated(Existing.class) @RequestBody CapUnitDto capUnitDto) {
        CapUnit capUnit = capUnitMapper.toEntity(capUnitDto);
        capUnitService.update(capUnit);
        return new ResponseEntity<>(capUnit.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCapUnit(@PathVariable("id") Long id) {
        capUnitService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
