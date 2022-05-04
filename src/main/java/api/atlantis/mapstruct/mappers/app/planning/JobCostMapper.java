package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.JobCost;
import api.atlantis.mapstruct.dto.app.planning.JobCostDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobCostMapper extends BaseMapper<JobCostDto, JobCost> {
    @Override
    @Mapping(target = "hcPlanningItemId", source = "hcPlanningItem.id")
    @Mapping(target = "costAccountId", source = "costAccount.id")
    @Mapping(target = "costAccountName", source = "costAccount.name")
    JobCostDto toDto(JobCost jobCost);

    @Override
    @Mapping(target = "hcPlanningItem.id", source = "hcPlanningItemId")
    @Mapping(target = "costAccount.id", source = "costAccountId")
    JobCost toEntity(JobCostDto jobCostDto);
}
