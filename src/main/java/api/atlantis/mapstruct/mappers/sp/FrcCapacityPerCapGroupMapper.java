package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.FrcCapacityPerCapGroup;
import api.atlantis.mapstruct.dto.sp.FrcCapacityPerCapGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrcCapacityPerCapGroupMapper extends BaseMapper<FrcCapacityPerCapGroupDto, FrcCapacityPerCapGroup> {
}
