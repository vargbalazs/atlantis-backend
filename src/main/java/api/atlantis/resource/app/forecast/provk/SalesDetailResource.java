package api.atlantis.resource.app.forecast.provk;

import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.provk.SalesDetailDto;
import api.atlantis.mapstruct.dto.sp.SalesDetailPerSalesProductDto;
import api.atlantis.mapstruct.mappers.app.forecast.provk.SalesDetailMapper;
import api.atlantis.mapstruct.mappers.sp.SalesDetailPerSalesProductMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.provk.SalesDetailService;
import api.atlantis.service.interfaces.sp.SalesDetailPerSalesProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/provk/salesdetail")
public class SalesDetailResource extends ExceptionHandling {
    private SalesDetailService salesDetailService;
    private SalesDetailPerSalesProductService salesDetailPerSalesProductService;
    private SalesDetailMapper salesDetailMapper;
    private SalesDetailPerSalesProductMapper salesDetailPerSalesProductMapper;

    public SalesDetailResource(SalesDetailService salesDetailService,
                               SalesDetailPerSalesProductService salesDetailPerSalesProductService,
                               SalesDetailMapper salesDetailMapper,
                               SalesDetailPerSalesProductMapper salesDetailPerSalesProductMapper) {
        this.salesDetailService = salesDetailService;
        this.salesDetailPerSalesProductService = salesDetailPerSalesProductService;
        this.salesDetailMapper = salesDetailMapper;
        this.salesDetailPerSalesProductMapper = salesDetailPerSalesProductMapper;
    }

    @GetMapping()
    public ResponseEntity<List<SalesDetailPerSalesProductDto>> getSalesDetails(@RequestParam(name = "provkId") Long provkId,
                                                                               @RequestParam(name = "year") int year,
                                                                               @RequestParam(name = "month") int month,
                                                                               @RequestParam(name = "version") int version,
                                                                               @RequestParam(name = "plantId") Long plantId) {
        List<SalesDetailPerSalesProductDto> salesDetailPerSalesProductDtos =
                salesDetailPerSalesProductMapper.toListDto(
                        salesDetailPerSalesProductService.getSalesDetails(provkId, year, month, version, plantId));
        return new ResponseEntity<>(salesDetailPerSalesProductDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveSalesDetails(@Validated(New.class) @RequestBody List<SalesDetailDto> salesDetailDtos) {
        salesDetailService.saveAll(salesDetailMapper.toListEntity(salesDetailDtos));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
