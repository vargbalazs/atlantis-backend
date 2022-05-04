package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.CostCenterOverview;
import api.atlantis.mapstruct.dto.sp.CostCenterOverviewDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostCenterOverviewMapper extends BaseMapper<CostCenterOverviewDto, CostCenterOverview> {
    @Override
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "plant.code", source = "plantCode")
    @Mapping(target = "plantArea.id", source = "plantAreaId")
    @Mapping(target = "plantArea.code", source = "plantAreaCode")
    @Mapping(target = "costCenter.id", source = "costCenterId")
    @Mapping(target = "costCenter.code", source = "costCenterCode")
    @Mapping(target = "costCenter.name", source = "costCenterName")
    CostCenterOverviewDto toDto(CostCenterOverview costCenterOverview);
}
