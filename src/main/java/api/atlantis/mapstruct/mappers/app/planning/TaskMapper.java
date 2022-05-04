package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.Task;
import api.atlantis.mapstruct.dto.app.planning.TaskDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<TaskDto, Task> {
}
