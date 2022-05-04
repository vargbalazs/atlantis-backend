package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.CompanyDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.CompanyMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.service.interfaces.app.masterdata.general.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/general/company")
public class CompanyResource extends ExceptionHandling {
    private CompanyService companyService;
    private CompanyMapper companyMapper;

    public CompanyResource(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        List<CompanyDto> companyDtos = companyMapper.toListDto(companyService.getAll());
        return new ResponseEntity<>(companyDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewCompany(@Validated(New.class) @RequestBody CompanyDto companyDto) {
        Long newId = companyService.addNew(companyMapper.toEntity(companyDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateCompany(@Validated(Existing.class) @RequestBody CompanyDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        companyService.update(company);
        return new ResponseEntity<>(company.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCompany(@PathVariable("id") Long id) {
        companyService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
