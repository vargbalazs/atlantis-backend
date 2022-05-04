package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.ProvkDetailPerCapGroup;
import api.atlantis.mapstruct.dto.sp.ProvkDetailPerCapGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvkDetailPerCapGroupMapper extends BaseMapper<ProvkDetailPerCapGroupDto, ProvkDetailPerCapGroup> {
}
