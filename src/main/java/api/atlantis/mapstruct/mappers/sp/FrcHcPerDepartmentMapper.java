package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.FrcHcPerDepartment;
import api.atlantis.mapstruct.dto.sp.FrcHcPerDepartmentDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrcHcPerDepartmentMapper extends BaseMapper<FrcHcPerDepartmentDto, FrcHcPerDepartment> {
}
