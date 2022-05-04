package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.CostPlanningItem;
import api.atlantis.mapstruct.dto.app.planning.CostPlanningItemDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostPlanningItemMapper extends BaseMapper<CostPlanningItemDto, CostPlanningItem> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "costAccTypeId", source = "costAccType.id")
    @Mapping(target = "costCenterId", source = "costCenter.id")
    @Mapping(target = "costAccountId", source = "costAccount.id")
    @Mapping(target = "costGroupId", source = "costGroup.id")
    @Mapping(target = "currencyId", source = "currency.id")
    @Mapping(target = "costGroupName", source = "costGroup.name")
    CostPlanningItemDto toDto(CostPlanningItem costPlanningItem);

    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "costAccType.id", source = "costAccTypeId")
    @Mapping(target = "costCenter.id", source = "costCenterId")
    CostPlanningItem toEntity(CostPlanningItemDto costPlanningItemDto);
}
