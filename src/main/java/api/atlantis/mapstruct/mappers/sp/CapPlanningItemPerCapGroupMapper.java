package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.CapPlanningItemPerCapGroup;
import api.atlantis.mapstruct.dto.sp.CapPlanningItemPerCapGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CapPlanningItemPerCapGroupMapper extends BaseMapper<CapPlanningItemPerCapGroupDto, CapPlanningItemPerCapGroup> {
}
