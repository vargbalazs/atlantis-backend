package api.atlantis.resource.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapGroupDto;
import api.atlantis.mapstruct.mappers.app.masterdata.production.CapGroupMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.production.CapGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/production/capgroup")
public class CapGroupResource extends ExceptionHandling {
    private CapGroupService capGroupService;
    private CapGroupMapper capGroupMapper;

    public CapGroupResource(CapGroupService capGroupService, CapGroupMapper capGroupMapper) {
        this.capGroupService = capGroupService;
        this.capGroupMapper = capGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<CapGroupDto>> getCapGroups() {
        List<CapGroupDto> capGroupDtos =
                capGroupMapper.toListDto(capGroupService.getAll());
        return new ResponseEntity<>(capGroupDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCapGroup(@Validated(New.class) @RequestBody CapGroupDto capGroupDto) {
        Long newId = capGroupService.addNew(capGroupMapper.toEntity(capGroupDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCapGroup(@Validated(Existing.class) @RequestBody CapGroupDto capGroupDto) {
        CapGroup capGroup = capGroupMapper.toEntity(capGroupDto);
        capGroupService.update(capGroup);
        return new ResponseEntity<>(capGroup.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCapType(@PathVariable("id") Long id) {
        capGroupService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
