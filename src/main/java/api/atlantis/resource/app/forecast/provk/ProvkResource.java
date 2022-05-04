package api.atlantis.resource.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkDto;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkVersionDto;
import api.atlantis.mapstruct.mappers.app.forecast.provk.ProvkMapper;
import api.atlantis.mapstruct.mappers.app.forecast.provk.ProvkVersionMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkDetailService;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkService;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkVersionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/provk")
public class ProvkResource extends ExceptionHandling {
    private ProvkService provkService;
    private ProvkVersionService provkVersionService;
    private ProvkDetailService provkDetailService;
    private ProvkMapper provkMapper;
    private ProvkVersionMapper provkVersionMapper;

    public ProvkResource(ProvkService provkService, ProvkVersionService provkVersionService,
                         ProvkDetailService provkDetailService, ProvkMapper provkMapper,
                         ProvkVersionMapper provkVersionMapper) {
        this.provkService = provkService;
        this.provkVersionService = provkVersionService;
        this.provkDetailService = provkDetailService;
        this.provkMapper = provkMapper;
        this.provkVersionMapper = provkVersionMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProvkDto>> getProvks(@RequestParam(name = "companyId") Long companyId,
                                                    @RequestParam(name = "plantId") Long plantId,
                                                    @RequestParam(name = "year") int year) {
        List<ProvkDto> provkDtos =
                provkMapper.toListDto(provkService.getProvks(companyId, plantId, year));
        return new ResponseEntity<>(provkDtos, HttpStatus.OK);
    }

    @GetMapping("{provkId}/versions")
    public ResponseEntity<List<ProvkVersionDto>> getProvkVersions(@PathVariable("provkId") Long provkId) {
        List<ProvkVersionDto> provkVersionDtos = provkVersionMapper.toListDto(provkVersionService.getProvkVersions(provkId));
        return new ResponseEntity<>(provkVersionDtos, HttpStatus.OK);
    }

    @GetMapping("/checkmonth")
    public ResponseEntity checkMonth(@RequestParam(name = "plantId") Long plantId, @RequestParam(name = "year") int year,
                                     @RequestParam(name = "month") int month) {
        return new ResponseEntity(provkService.monthAlreadyExists(plantId, year, month), HttpStatus.OK);
    }

    @GetMapping("/hasversions")
    public ResponseEntity hasVersions(@RequestParam(name = "provkId") Long provkId) {
        return new ResponseEntity(provkVersionService.hasVersions(provkId), HttpStatus.OK);
    }

    @GetMapping("/nextversion/{provkid}")
    public ResponseEntity getNextVersion(@PathVariable("provkid") Long provkId) {
        return new ResponseEntity(provkVersionService.getNextVersionNumber(provkId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewProvk(@Validated(New.class) @RequestBody ProvkDto provkDto) {
        Long newId = provkService.addNew(provkMapper.toEntity(provkDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PostMapping("/newversion")
    public ResponseEntity<Long> addNewVersion(@Validated(New.class) @RequestBody ProvkVersionDto provkVersionDto) {
        Long newId = provkVersionService.addNew(provkVersionMapper.toEntity(provkVersionDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateProvk(@Validated(Existing.class) @RequestBody ProvkDto provkDto) {
        Provk provk = provkMapper.toEntity(provkDto);
        provkService.update(provk);
        return new ResponseEntity<>(provk.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteProvk(@PathVariable("id") Long id) {
        provkService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
