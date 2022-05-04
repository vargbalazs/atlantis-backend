package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocation;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAllocationDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostAllocationMapper extends BaseMapper<CostAllocationDto, CostAllocation> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "allocCostCenterId", source = "allocCostCenter.id")
    @Mapping(target = "costAccountId", source = "costAccount.id")
    CostAllocationDto toDto(CostAllocation costAllocation);
}
