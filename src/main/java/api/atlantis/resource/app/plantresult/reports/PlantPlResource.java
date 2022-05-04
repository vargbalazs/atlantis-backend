package api.atlantis.resource.app.plantresult.reports;

import api.atlantis.domain.sp.PlantPl;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.sp.PlantPlDto;
import api.atlantis.mapstruct.mappers.sp.PlantPlMapper;
import api.atlantis.service.interfaces.sp.PlantPlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plantresult/reports")
public class PlantPlResource extends ExceptionHandling {
    private PlantPlService plantPlService;
    private PlantPlMapper plantPlMapper;

    public PlantPlResource(PlantPlService plantPlService, PlantPlMapper plantPlMapper) {
        this.plantPlService = plantPlService;
        this.plantPlMapper = plantPlMapper;
    }

    @GetMapping("/plantpl")
    public ResponseEntity<List<PlantPlDto>> getPlantPl(@RequestParam(name = "year") int year,
                                                       @RequestParam(name = "month") int month,
                                                       @RequestParam(name = "costAccTypeId") Long costAccTypeId,
                                                       @RequestParam(name = "plantId") Long plantId,
                                                       @RequestParam(name = "companyId") Long companyId) {
        List<PlantPl> plantPls = plantPlService.getPlantPl(year, month, costAccTypeId, plantId, companyId);
        List<PlantPlDto> plantPlDtos = plantPlMapper.toListDto(plantPls);

        return new ResponseEntity<>(plantPlDtos, HttpStatus.OK);
    }
}
