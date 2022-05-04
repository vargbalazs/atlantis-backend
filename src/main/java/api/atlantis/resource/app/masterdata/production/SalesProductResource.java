package api.atlantis.resource.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.SalesProduct;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.production.SalesProductDto;
import api.atlantis.mapstruct.mappers.app.masterdata.production.SalesProductMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.production.SalesProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/production/salesproduct")
public class SalesProductResource extends ExceptionHandling {
    private SalesProductService salesProductService;
    private SalesProductMapper salesProductMapper;

    public SalesProductResource(SalesProductService salesProductService, SalesProductMapper salesProductMapper) {
        this.salesProductService = salesProductService;
        this.salesProductMapper = salesProductMapper;
    }

    @GetMapping
    public ResponseEntity<List<SalesProductDto>> getSalesProducts() {
        List<SalesProductDto> salesProductDtos =
                salesProductMapper.toListDto(salesProductService.getAll());
        return new ResponseEntity<>(salesProductDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewSalesProduct(@Validated(New.class) @RequestBody SalesProductDto salesProductDto) {
        Long newId = salesProductService.addNew(salesProductMapper.toEntity(salesProductDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateSalesProduct(@Validated(Existing.class) @RequestBody SalesProductDto salesProductDto) {
        SalesProduct salesProduct = salesProductMapper.toEntity(salesProductDto);
        salesProductService.update(salesProduct);
        return new ResponseEntity<>(salesProduct.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteSalesProduct(@PathVariable("id") Long id) {
        salesProductService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
