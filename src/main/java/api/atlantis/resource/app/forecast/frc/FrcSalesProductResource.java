package api.atlantis.resource.app.forecast.frc;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcSalesProductDto;
import api.atlantis.mapstruct.dto.sp.FrcSalesProductPerCapGroupDto;
import api.atlantis.mapstruct.mappers.app.forecast.frc.FrcSalesProductMapper;
import api.atlantis.mapstruct.mappers.sp.FrcSalesProductPerCapGroupMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.frc.FrcSalesProductService;
import api.atlantis.service.interfaces.sp.FrcSalesProductPerCapGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/frc/salesproduct")
public class FrcSalesProductResource extends ExceptionHandling {
    private FrcSalesProductService frcSalesProductService;
    private FrcSalesProductPerCapGroupService frcSalesProductPerCapGroupService;
    private FrcSalesProductMapper frcSalesProductMapper;
    private FrcSalesProductPerCapGroupMapper frcSalesProductPerCapGroupMapper;

    public FrcSalesProductResource(FrcSalesProductService frcSalesProductService,
                                   FrcSalesProductPerCapGroupService frcSalesProductPerCapGroupService,
                                   FrcSalesProductMapper frcSalesProductMapper,
                                   FrcSalesProductPerCapGroupMapper frcSalesProductPerCapGroupMapper) {
        this.frcSalesProductService = frcSalesProductService;
        this.frcSalesProductPerCapGroupService = frcSalesProductPerCapGroupService;
        this.frcSalesProductMapper = frcSalesProductMapper;
        this.frcSalesProductPerCapGroupMapper = frcSalesProductPerCapGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<FrcSalesProductPerCapGroupDto>> getFrcSalesProducts(
            @RequestParam(name = "frcId") Long frcId,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "plantId") Long plantId) {
        List<FrcSalesProductPerCapGroup> frcSalesProductPerCapGroups =
                frcSalesProductPerCapGroupService.getFrcSalesProducts(frcId, year, plantId);
        return new ResponseEntity<>(frcSalesProductPerCapGroupMapper.toListDto(frcSalesProductPerCapGroups), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveFrcSalesProduct(@Validated(New.class) @RequestBody FrcSalesProductDto frcSalesProductDto) {
        Long id = frcSalesProductService.update(frcSalesProductMapper.toEntity(frcSalesProductDto));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
