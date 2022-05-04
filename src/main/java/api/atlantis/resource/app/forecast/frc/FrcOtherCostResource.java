package api.atlantis.resource.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcOtherCost;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcOtherCostDto;
import api.atlantis.mapstruct.mappers.app.forecast.frc.FrcOtherCostMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.frc.FrcOtherCostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/frc")
public class FrcOtherCostResource extends ExceptionHandling {
    private FrcOtherCostService frcOtherCostService;
    private FrcOtherCostMapper frcOtherCostMapper;

    public FrcOtherCostResource(FrcOtherCostService frcOtherCostService, FrcOtherCostMapper frcOtherCostMapper) {
        this.frcOtherCostService = frcOtherCostService;
        this.frcOtherCostMapper = frcOtherCostMapper;
    }

    @GetMapping("/othercosts")
    public ResponseEntity<List<FrcOtherCostDto>> getOtherCosts(@RequestParam(name = "frcId") Long frcId) {
        List<FrcOtherCost> frcOtherCosts = frcOtherCostService.getFrcCosts(frcId);
        return new ResponseEntity<>(frcOtherCostMapper.toListDto(frcOtherCosts), HttpStatus.OK);
    }

    @PostMapping("/othercosts")
    public ResponseEntity<Long> addNewCost(@Validated(New.class) @RequestBody FrcOtherCostDto frcOtherCostDto) {
        Long newId = frcOtherCostService.addNew(frcOtherCostMapper.toEntity(frcOtherCostDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping("/othercosts")
    public ResponseEntity<Long> updateCost(@Validated(Existing.class) @RequestBody FrcOtherCostDto frcOtherCostDto) {
        FrcOtherCost frcOtherCost = frcOtherCostMapper.toEntity(frcOtherCostDto);
        frcOtherCostService.update(frcOtherCost);
        return new ResponseEntity<>(frcOtherCost.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/othercosts/{id}")
    public ResponseEntity<Long> deleteCost(@PathVariable(name = "id") Long id) {
        frcOtherCostService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
