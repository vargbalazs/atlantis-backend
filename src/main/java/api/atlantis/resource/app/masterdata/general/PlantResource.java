package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.PlantMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.PK;
import api.atlantis.service.interfaces.app.masterdata.general.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/general/plant")
public class PlantResource extends ExceptionHandling {
    private PlantService plantService;
    private PlantMapper plantMapper;

    public PlantResource(PlantService plantService, PlantMapper plantMapper) {
        this.plantService = plantService;
        this.plantMapper = plantMapper;
    }

    @GetMapping
    public ResponseEntity<List<PlantDto>> getPlants() {
        List<PlantDto> plantDtos = plantMapper.toListDto(plantService.getAll());
        return new ResponseEntity<>(plantDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewPlant(@Validated({New.class, PK.class}) @RequestBody PlantDto plantDto) {
        Long newId = plantService.addNew(plantMapper.toEntity(plantDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updatePlant(@Validated(Existing.class) @RequestBody PlantDto plantDto) {
        Plant plant = plantMapper.toEntity(plantDto);
        plantService.update(plant);
        return new ResponseEntity<>(plant.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deletePlant(@PathVariable("id") Long id) {
        plantService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
