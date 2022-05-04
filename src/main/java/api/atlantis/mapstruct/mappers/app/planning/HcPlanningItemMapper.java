package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.HcPlanningItem;
import api.atlantis.mapstruct.dto.app.planning.HcPlanningItemDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HcPlanningItemMapper extends BaseMapper<HcPlanningItemDto, HcPlanningItem> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "costAccTypeId", source = "costAccType.id")
    @Mapping(target = "costCenterId", source = "costCenter.id")
    @Mapping(target = "costGroupId", source = "costGroup.id")
    @Mapping(target = "jobId", source = "job.id")
    @Mapping(target = "departmentName", source = "job.department.name")
    HcPlanningItemDto toDto(HcPlanningItem hcPlanningItem);

    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "costAccType.id", source = "costAccTypeId")
    @Mapping(target = "costCenter.id", source = "costCenterId")
    @Mapping(target = "costGroup.id", source = "costGroupId")
    @Mapping(target = "job.id", source = "jobId")
    HcPlanningItem toEntity(HcPlanningItemDto hcPlanningItemDto);
}
