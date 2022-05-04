package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.ActualCapacityPerCapGroup;
import api.atlantis.mapstruct.dto.sp.ActualCapacityPerCapGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActualCapacityPerCapGroupMapper extends BaseMapper<ActualCapacityPerCapGroupDto, ActualCapacityPerCapGroup> {
}
