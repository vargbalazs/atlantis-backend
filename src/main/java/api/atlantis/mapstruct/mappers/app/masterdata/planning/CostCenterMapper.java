package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostCenter;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostCenterDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostCenterMapper extends BaseMapper<CostCenterDto, CostCenter>{
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "plantAreaId", source = "plantArea.id")
    CostCenterDto toDto(CostCenter costCenter);
}
