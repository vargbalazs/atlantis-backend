package api.atlantis.resource.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountDto;
import api.atlantis.mapstruct.mappers.app.masterdata.planning.CostAccountMapper;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.masterdata.planning.CostAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/planning/costaccount")
public class CostAccountResource extends ExceptionHandling {
    private CostAccountService costAccountService;
    private CostAccountMapper costAccountMapper;

    public CostAccountResource(CostAccountService costAccountService, CostAccountMapper costAccountMapper) {
        this.costAccountService = costAccountService;
        this.costAccountMapper = costAccountMapper;
    }

    @GetMapping
    public ResponseEntity<List<CostAccountDto>> getCostAccounts() {
        List<CostAccountDto> costAccountDtos =
                costAccountMapper.toListDto(costAccountService.getAll());
        return new ResponseEntity<>(costAccountDtos, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CostAccountDto>> getFilteredCostAccounts(@RequestParam(name = "companyId") Long companyId,
                                                                        @RequestParam(name = "year") int year) {
        List<CostAccountDto> costAccountDtos =
                costAccountMapper.toListDto(costAccountService.getCostAccounts(companyId, year));
        return new ResponseEntity<>(costAccountDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCostAccount(@Validated(New.class) @RequestBody CostAccountDto costAccountDto) {
        Long newId = costAccountService.addNew(costAccountMapper.toEntity(costAccountDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCostAccount(@Validated(Existing.class) @RequestBody CostAccountDto costAccountDto) {
        CostAccount costAccount = costAccountMapper.toEntity(costAccountDto);
        costAccountService.update(costAccount);
        return new ResponseEntity<>(costAccount.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCostAccount(@PathVariable("id") Long id) {
        costAccountService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
