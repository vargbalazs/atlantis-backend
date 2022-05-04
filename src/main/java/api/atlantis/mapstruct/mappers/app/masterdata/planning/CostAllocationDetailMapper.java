package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAllocationDetail;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAllocationDetailDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostAllocationDetailMapper extends BaseMapper<CostAllocationDetailDto, CostAllocationDetail> {
    @Override
    @Mapping(target = "costAllocId", source = "costAllocation.id")
    @Mapping(target = "baseCostCenterId", source = "baseCostCenter.id")
    @Mapping(target = "recCostCenterId", source = "recCostCenter.id")
    CostAllocationDetailDto toDto(CostAllocationDetail costAllocationDetail);
}
