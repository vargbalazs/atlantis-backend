package api.atlantis.mapstruct.mappers.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapGroup;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapGroupDto;
import api.atlantis.mapstruct.dto.app.planning.CapPlanningItemDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CapGroupMapper extends BaseMapper<CapGroupDto, CapGroup> {
    @Override
    @Mapping(target = "capTypeId", source = "capType.id")
    @Mapping(target = "capUnitId", source = "capUnit.id")
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    CapGroupDto toDto(CapGroup capGroup);

}
