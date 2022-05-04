package api.atlantis.resource.app.planning;

import api.atlantis.domain.app.planning.Task;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.planning.TaskDto;
import api.atlantis.mapstruct.dto.sp.TaskForHomeDto;
import api.atlantis.mapstruct.mappers.app.planning.TaskMapper;
import api.atlantis.mapstruct.mappers.sp.TaskForHomeMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.service.interfaces.app.planning.TaskService;
import api.atlantis.service.interfaces.sp.TaskForHomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/planning/task")
public class TaskResource extends ExceptionHandling {
    private TaskService taskService;
    private TaskMapper taskMapper;
    private TaskForHomeService taskForHomeService;
    private TaskForHomeMapper taskForHomeMapper;

    public TaskResource(TaskService taskService, TaskMapper taskMapper, TaskForHomeService taskForHomeService,
                        TaskForHomeMapper taskForHomeMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.taskForHomeService = taskForHomeService;
        this.taskForHomeMapper = taskForHomeMapper;
    }

    @PatchMapping
    public ResponseEntity<Long> updateTask(@Validated(New.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Long planningItemId = taskService.update(task, taskDto.getPlanningItemId(), taskDto.getTaskType());
        return new ResponseEntity<>(planningItemId, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskForHomeDto>> getTasks() {
        return new ResponseEntity<>(taskForHomeMapper.toListDto(taskForHomeService.getTasks()), HttpStatus.OK);
    }
}
