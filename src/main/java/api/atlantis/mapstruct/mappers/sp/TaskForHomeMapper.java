package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.TaskForHome;
import api.atlantis.mapstruct.dto.sp.TaskForHomeDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskForHomeMapper extends BaseMapper<TaskForHomeDto, TaskForHome> {
}
