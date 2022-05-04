package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.CapPlanningItem;
import api.atlantis.mapstruct.dto.app.planning.CapPlanningItemDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CapPlanningItemMapper extends BaseMapper<CapPlanningItemDto, CapPlanningItem> {
    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "costAccType.id", source = "costAccTypeId")
    @Mapping(target = "capGroup.id", source = "capGroupId")
    CapPlanningItem toEntity(CapPlanningItemDto capPlanningItemDto);
}
