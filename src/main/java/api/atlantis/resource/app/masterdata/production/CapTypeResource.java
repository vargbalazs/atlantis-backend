package api.atlantis.resource.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapType;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapTypeDto;
import api.atlantis.mapstruct.mappers.app.masterdata.production.CapTypeMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.production.CapTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/production/captype")
public class CapTypeResource extends ExceptionHandling {
    private CapTypeService capTypeService;
    private CapTypeMapper capTypeMapper;

    public CapTypeResource(CapTypeService capTypeService, CapTypeMapper capTypeMapper) {
        this.capTypeService = capTypeService;
        this.capTypeMapper = capTypeMapper;
    }

    @GetMapping
    public ResponseEntity<List<CapTypeDto>> getCapTypes(@RequestParam(name = "plantId", required = false) Long plantId) {
        List<CapTypeDto> capTypeDtos = new ArrayList<>();
        if (plantId == null) {
            capTypeDtos = capTypeMapper.toListDto(capTypeService.getAll());
        } else {
            capTypeDtos = capTypeMapper.toListDto(capTypeService.getCapTypesByPlantId(plantId));
        }
        return new ResponseEntity<>(capTypeDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCapType(@Validated(New.class) @RequestBody CapTypeDto capTypeDto) {
        Long newId = capTypeService.addNew(capTypeMapper.toEntity(capTypeDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCapType(@Validated(Existing.class) @RequestBody CapTypeDto capTypeDto) {
        CapType capType = capTypeMapper.toEntity(capTypeDto);
        capTypeService.update(capType);
        return new ResponseEntity<>(capType.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCapType(@PathVariable("id") Long id) {
        capTypeService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
