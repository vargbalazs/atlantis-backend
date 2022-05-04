package api.atlantis.resource.app.plantresult.reports;

import api.atlantis.domain.sp.CostCenterDetails;
import api.atlantis.domain.sp.CostCenterOverview;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.sp.CostCenterDetailsDto;
import api.atlantis.mapstruct.dto.sp.CostCenterOverviewDto;
import api.atlantis.mapstruct.mappers.sp.CostCenterDetailsMapper;
import api.atlantis.mapstruct.mappers.sp.CostCenterOverviewMapper;
import api.atlantis.service.interfaces.sp.CostCenterDetailsService;
import api.atlantis.service.interfaces.sp.CostCenterOverviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plantresult/reports")
public class CostCenterReportResource extends ExceptionHandling {
    private CostCenterOverviewService  costCenterOverviewService;
    private CostCenterDetailsService costCenterDetailsService;
    private CostCenterOverviewMapper costCenterOverviewMapper;
    private CostCenterDetailsMapper costCenterDetailsMapper;

    public CostCenterReportResource(CostCenterOverviewService costCenterOverviewService,
                                    CostCenterDetailsService costCenterDetailsService,
                                    CostCenterOverviewMapper costCenterOverviewMapper,
                                    CostCenterDetailsMapper costCenterDetailsMapper) {
        this.costCenterOverviewService = costCenterOverviewService;
        this.costCenterDetailsService = costCenterDetailsService;
        this.costCenterOverviewMapper = costCenterOverviewMapper;
        this.costCenterDetailsMapper = costCenterDetailsMapper;
    }

    @GetMapping("/costcenteroverview")
    public ResponseEntity<List<CostCenterOverviewDto>> getCostCenterOverview(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "month") int month,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId,
            @RequestParam(name = "plantId") Long plantId) {
        List<CostCenterOverview> costCenterOverviews = costCenterOverviewService
                .getCostCenterOverview(year, month, costAccTypeId, plantId);
        List<CostCenterOverviewDto> costCenterOverviewDtos = this.costCenterOverviewMapper.toListDto(costCenterOverviews);

        return new ResponseEntity<>(costCenterOverviewDtos, HttpStatus.OK);
    }

    @GetMapping("/costcenterdetails")
    public ResponseEntity<List<CostCenterDetailsDto>> getCostCenterDetails(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "month") int month,
            @RequestParam(name = "costCenterId") Long costCenterId,
            @RequestParam(name = "costAccTypeId") Long costAccTypeId,
            @RequestParam(name = "plantId") Long plantId,
            @RequestParam(name = "companyId") Long companyId) {
        List<CostCenterDetails> costCenterDetails = costCenterDetailsService
                .getCostCenterDetails(year, month, costCenterId, costAccTypeId, plantId, companyId);
        List<CostCenterDetailsDto> costCenterDetailsDtos = this.costCenterDetailsMapper.toListDto(costCenterDetails);

        return new ResponseEntity<>(costCenterDetailsDtos, HttpStatus.OK);
    }

}
