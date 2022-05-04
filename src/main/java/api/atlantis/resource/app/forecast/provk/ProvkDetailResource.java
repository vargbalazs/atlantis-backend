package api.atlantis.resource.app.forecast.provk;

import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkDetailDto;
import api.atlantis.mapstruct.dto.sp.ProvkDetailPerCapGroupDto;
import api.atlantis.mapstruct.mappers.app.forecast.provk.ProvkDetailMapper;
import api.atlantis.mapstruct.mappers.sp.ProvkDetailPerCapGroupMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.forecast.provk.ProvkDetailService;
import api.atlantis.service.interfaces.sp.ProvkDetailPerCapGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/forecast/provk/provkdetail")
public class ProvkDetailResource extends ExceptionHandling {
    private ProvkDetailService provkDetailService;
    private ProvkDetailPerCapGroupService provkDetailPerCapGroupService;
    private ProvkDetailMapper provkDetailMapper;
    private ProvkDetailPerCapGroupMapper provkDetailPerCapGroupMapper;

    public ProvkDetailResource(ProvkDetailService provkDetailService,
                               ProvkDetailPerCapGroupService provkDetailPerCapGroupService,
                               ProvkDetailMapper provkDetailMapper,
                               ProvkDetailPerCapGroupMapper provkDetailPerCapGroupMapper) {
        this.provkDetailService = provkDetailService;
        this.provkDetailPerCapGroupService = provkDetailPerCapGroupService;
        this.provkDetailMapper = provkDetailMapper;
        this.provkDetailPerCapGroupMapper = provkDetailPerCapGroupMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProvkDetailPerCapGroupDto>> getProvkDetails(@RequestParam(name = "provkId") Long provkId,
                                                                           @RequestParam(name = "year") int year,
                                                                           @RequestParam(name = "month") int month,
                                                                           @RequestParam(name = "version") int version,
                                                                           @RequestParam(name = "capTypeId") Long capTypeId,
                                                                           @RequestParam(name = "plantId") Long plantId) {
        List<ProvkDetailPerCapGroupDto> provkDetailPerCapGroupDtos =
                provkDetailPerCapGroupMapper.toListDto(provkDetailPerCapGroupService
                        .getProvkDetails(provkId, year, month, version, capTypeId, plantId));
        return new ResponseEntity<>(provkDetailPerCapGroupDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveProvkDetails(@Validated(New.class) @RequestBody List<ProvkDetailDto> provkDetailDtos) {
        provkDetailService.saveAll(provkDetailMapper.toListEntity(provkDetailDtos));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
