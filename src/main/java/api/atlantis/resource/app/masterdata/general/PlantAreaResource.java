package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.PlantArea;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantAreaDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.PlantAreaMapper;
import api.atlantis.service.interfaces.app.masterdata.general.PlantAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/general/plantarea")
public class PlantAreaResource extends ExceptionHandling {
    private PlantAreaService plantAreaService;
    private PlantAreaMapper plantAreaMapper;

    public PlantAreaResource(PlantAreaService plantAreaService, PlantAreaMapper plantAreaMapper) {
        this.plantAreaService = plantAreaService;
        this.plantAreaMapper = plantAreaMapper;
    }

    @GetMapping
    public ResponseEntity<List<PlantAreaDto>> getPlantAreas() {
        List<PlantAreaDto> plantAreaDtos = plantAreaMapper.toListDto(plantAreaService.getAll());
        return new ResponseEntity<>(plantAreaDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewPlantArea(@RequestBody PlantAreaDto plantAreaDto) {
        Long newId = plantAreaService.addNew(plantAreaMapper.toEntity(plantAreaDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updatePlantArea(@RequestBody PlantAreaDto plantAreaDto) {
        PlantArea plantArea = plantAreaMapper.toEntity(plantAreaDto);
        plantAreaService.update(plantArea);
        return new ResponseEntity<>(plantArea.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deletePlantArea(@PathVariable("id") Long id) {
        plantAreaService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
