package api.atlantis.resource.app.planning;

import api.atlantis.domain.app.masterdata.production.SalesProduct;
import api.atlantis.domain.app.planning.Version;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.production.SalesProductDto;
import api.atlantis.mapstruct.dto.app.planning.VersionDto;
import api.atlantis.mapstruct.mappers.app.planning.VersionMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.planning.VersionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/planning/version")
public class VersionResource extends ExceptionHandling {
    private VersionService versionService;
    private VersionMapper versionMapper;

    public VersionResource(VersionService versionService, VersionMapper versionMapper) {
        this.versionService = versionService;
        this.versionMapper = versionMapper;
    }

    @GetMapping
    public ResponseEntity<List<VersionDto>> getVersions() {
        List<VersionDto> versionDtos =
                versionMapper.toListDto(versionService.getAll());
        return new ResponseEntity<>(versionDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewVersion(@Validated(New.class) @RequestBody VersionDto versionDto) {
        Long newId = versionService.addNew(versionMapper.toEntity(versionDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateVersion(@Validated(Existing.class) @RequestBody VersionDto versionDto) {
        Version version = versionMapper.toEntity(versionDto);
        versionService.update(version);
        return new ResponseEntity<>(version.getId(), HttpStatus.OK);
    }

}
